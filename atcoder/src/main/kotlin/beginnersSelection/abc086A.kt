package beginnersSelection

import java.util.*

fun abc086a() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val result = if ((a * b) % 2 == 0) {
        "Even"
    } else {
        "Odd"
    }
    print(result)
}

fun main() {
    abc086a()
}
