package practiceContest

class B(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val (n, q) = readLine()!!.split(" ").map { it.toInt() }

        val chars = List(n) {
            'A' + it
        }

        // 全パターン網羅はできない (q がたりない)
        // q が許す限り、ソートのステップを進める感じが良さそう
        // TODO キャッシュするとかはできそう
        var count = 0
        val res = chars.sortedWith(Comparator { a, b ->
            if (count >= q) {
                throw RuntimeException("q を使い切ってしまった。。")
            }
            println("? $a $b")
            val res = readLine()
            count++
            if (res == ">") {
                1
            } else {
                -1
            }
        })

        println("! " + res.joinToString(""))
    }
}

fun main() {
    B(false).solve()
}