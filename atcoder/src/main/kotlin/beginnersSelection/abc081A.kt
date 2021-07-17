package beginnersSelection

import java.util.*

fun abc081a(log: Boolean = true) {
    val a = Scanner(System.`in`).nextLine()

    val res = a.count {
        it == '1'
    }
    print(res)
}

fun main() {
    abc081a(false)
}