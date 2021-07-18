import java.io.*
import java.nio.file.Files
import java.nio.file.Path

/**
 * 指定したデータを標準出力から読み込み、標準出力を関数の戻り値として返す
 */
fun replaceStdio(
    inputStream: InputStream,
    outputStream: OutputStream,
    f: () -> Unit
): String {
    val originalOut = System.out
    val originalIn = System.`in`
    try {
        val outputPrintStream = PrintStream(outputStream)

        System.setIn(inputStream)
        System.setOut(outputPrintStream)
        f()
        return outputStream.toString()
    } finally {
        // これで戻せてるかなぁ?
        System.setIn(originalIn)
        System.setOut(originalOut)
    }
}

/**
 * 指定したデータを標準出力から読み込み、標準出力を関数の戻り値として返す
 */
fun captureStdio(
    input: String,
    f: () -> Unit
): String {
    val inputStream = ByteArrayInputStream(input.toByteArray())
    val outputStream = ByteArrayOutputStream()
    replaceStdio(inputStream, outputStream, f)
    return outputStream.toString()
}

object TestUtil {
    fun test(
        input: String,
        f: (input: InputStream, output: PrintStream) -> Unit
    ): String {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        return test(inputStream, f)
    }

    /**
     * 指定したデータを標準出力から読み込み、標準出力を関数の戻り値として返す
     */
    @Deprecated("", ReplaceWith("captureStdio(input, f)"))
    fun testWithStdio(
        input: String,
        f: () -> Unit
    ): String {
        return captureStdio(input, f)
    }

    fun test(
        f: (output: PrintStream) -> Unit
    ): String {
        val outputStream = ByteArrayOutputStream()
        val outputPrintStream = PrintStream(outputStream)
        f(outputPrintStream)
        return outputStream.toString()
    }

    fun test(
        input: Path, f: (input: InputStream, output: PrintStream) -> Unit
    ): String {
        val inputStream = Files.newInputStream(input)
        return test(inputStream, f)
    }

    fun toFile(
        input: Path, output: Path, f: (input: InputStream, output: PrintStream) -> Unit
    ) {
        val inputStream = Files.newInputStream(input)
        val outputStream = Files.newOutputStream(output)
        val outputPrintStrema = PrintStream(outputStream)
        f(inputStream, outputPrintStrema)
    }

    fun test(
        input: InputStream, f: (input: InputStream, output: PrintStream) -> Unit
    ): String {
        val outputStream = ByteArrayOutputStream()
        val outputPrintStream = PrintStream(outputStream)
        f(input, outputPrintStream)
        return outputStream.toString()
    }
}
