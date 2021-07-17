import java.io.InputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.io.PrintStream
import kotlin.concurrent.thread

fun interactive(
    target: () -> Unit,
    responder: (
        input: InputStream, output: PrintStream
    ) -> Unit
) {
    PipedInputStream().use { tInput ->
        PrintStream(PipedOutputStream(tInput)).use { rOutput ->
            PipedInputStream().use { rInput ->
                PipedOutputStream(rInput).use { tOutput ->
                    val a = thread {
                        System.err.println("テスト対象のスレッド開始")
                        replaceStdio(tInput, tOutput) {
                            target()
                        }
                        System.err.println("テスト対象のスレッド終了")
                    }

                    responder(rInput, rOutput)

                    a.join()
                }
            }
        }
    }
}

fun interactive(
    target: () -> Unit,
    initialInput: String,
    expected: String,
    responder: (String) -> String
) {
    interactive(target) { input, output ->
        System.err.println("responder のスレッド開始")

        output.println(initialInput)
        output.flush()

        val r = input.bufferedReader()

        var count = 0
        while (true) {
            val line = r.readLine()
            System.err.println("responder read: $line")

            if (line == expected) {
                break // OK!
            }

            val w = responder(line)

            System.err.println("responder write: $w")
            output.println(w)
            count++
            if (count > 100) {
                throw RuntimeException("ループが多すぎます")
            }
        }
        System.err.println("responder のスレッド終了")
    }
}

