package practiceContest

class B(private val logging: Boolean = true) {
    /**
     * 同じ重さのものがないため、 = になることがない
     *
     * その前提でキャッシュをすることで、若干比較回数を減らせる
     */
    class Cache {
        data class Key(val first: Char, val second: Char)

        private val map = mutableMapOf<Key, Int>()

        fun get(first: Char, second: Char): Int? {
            return map[Key(first, second)]
        }

        fun put(first: Char, second: Char, comp: Int) {
            map[Key(first, second)] = comp
            map[Key(second, first)] = comp * -1
        }
    }

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

        val cache = Cache()

        // 全パターン網羅はできない (q がたりない)
        // q が許す限り、ソートのステップを進める感じが良さそう
        var count = 0
        val res = chars.sortedWith(Comparator { a, b ->
            val comp = cache.get(a, b)
            if (comp != null) {
                log("use cache")
                comp
            } else {
                if (count >= q) {
                    // RE が識別できないので、 TLE にする
                    Thread.sleep(3 * 1000)
                    throw RuntimeException("q を使い切ってしまった。。")
                }
                println("? $a $b")
                val res = readLine()
                count++
                val comp2 = if (res == ">") {
                    1
                } else {
                    -1
                }
                cache.put(a, b, comp2)
                comp2
            }
        })

        println("! " + res.joinToString(""))
    }
}

fun main() {
    B(false).solve()
}