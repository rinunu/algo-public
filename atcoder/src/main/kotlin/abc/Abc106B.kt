package abc

class Abc106B(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val n = readLine()!!.toInt()
        val res = (1..n)
            .filter { it % 2 != 0 }
            .filter {
                val c = count(it)
                log("cnt = $c")
                c == 8
            }
        log(res)
        print(res.size)
    }

    private fun count(a: Int): Int {
        var c = 0
        for (b in 1..a) {
            if (a % b == 0) {
                log("$a $b: ok")
                c++
            }
        }
        return c
    }
}

fun main() {
    Abc106B(false).solve()
}