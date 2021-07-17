package beginnersSelection

import java.util.*

class Abc081b(private val logging: Boolean = true) {
    fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val s = Scanner(System.`in`)
        val n = s.nextInt()
        val nums = List(n) {
            s.nextInt()
        }

        val a = nums.map { count(it) }
        log(a)

        // 一番回数が少ないものが、足を引っ張るので、それが答え
        val b = a.sortedBy { it }.first()
        print(b)
    }

    private tailrec
    fun count(num: Int, c: Int = 0): Int {
        if (num % 2 != 0) {
            return c
        }
        return count(num / 2, c + 1)
    }
}


fun main() {
    Abc081b(false).solve()
}
