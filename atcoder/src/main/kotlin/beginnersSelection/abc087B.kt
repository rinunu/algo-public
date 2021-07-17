package beginnersSelection

import java.util.*

class Abc087B(private val logging: Boolean = true) {
    fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    // とりあえず全件検索でできるね
    fun solve() {
        val s = Scanner(System.`in`)
        val a = s.nextInt()
        val b = s.nextInt()
        val c = s.nextInt()
        val x = s.nextInt()

        // こんな関係があるが。。
        // a = b * 5
        // b = c * 2

        val result = mutableListOf<Int>()
        for (ia in 0..a) {
            for (ib in 0..b) {
                for (ic in 0..c) {
                    val n = 500 * ia + 100 * ib + ic * 50
                    if (n == x) {
                        result.add(n)
                    }
                }
            }
        }
        print(result.size)
    }
}

fun main() {
    Abc087B(false).solve()
}
