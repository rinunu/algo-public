package aoj.itp1

class ITP1_7_B(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        // 全探索でいける
        val r = System.`in`.bufferedReader()
        while (true) {
            val line = r.readLine()
            val (n, x) = line.split(" ").map { it.toInt() }
            if (n == 0 && x == 0) {
                break
            }
            println(solve(n, x))
        }
    }

    private fun solve(n: Int, x: Int): Int {
        // a < b < c という感じで列挙する
        var count = 0
        for (a in 1..n) {
            for (b in (a + 1)..n) {
                for (c in (b + 1)..n) {
                    log("$a $b $c")
                    if (a + b + c == x) {
                        count++
                    }
                }
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    ITP1_7_B(false).solve()
}
