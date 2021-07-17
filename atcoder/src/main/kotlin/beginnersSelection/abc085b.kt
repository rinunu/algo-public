package beginnersSelection

import java.util.*

class Abc085B(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val scanner = Scanner(System.`in`)
        val n = scanner.nextInt()
        val items = List(n) {
            scanner.nextInt()
        }

        // 数値に重複がある場合、それを除外するだけでいい?
        val s1 = items.groupBy { it }
        val dup = s1.map { it.value.size - 1 }.sum()
        print(n - dup)
    }
}

fun main() {
    Abc085B(false).solve()
}


