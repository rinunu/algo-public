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
            if (first == second) {
                return 0
            }
            return map[Key(first, second)]
        }

        fun put(first: Char, second: Char, comp: Int) {
            map[Key(first, second)] = comp
            map[Key(second, first)] = comp * -1
        }
    }

    private val cache = Cache()

    private var count = 0
    private var q = 0

    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val (n, q2) = readLine()!!.split(" ").map { it.toInt() }
        q = q2

        val chars = List(n) {
            'A' + it
        }

        val res = if (n == 5) {
            sort5(chars)
        } else {
            // 全パターン網羅はできない (q がたりない)
            // q が許す限り、ソートのステップを進める感じが良さそう
            sort(chars)
        }
        println("! " + res.joinToString(""))
    }

    /**
     * 5 つの要素に特化したソート
     */
    private fun sort5(chars: List<Char>): List<Char> {
        log("special sort")
        val a = chars[0]
        val b = chars[1]
        val c = chars[2]
        val d = chars[3]
        val e = chars[4]

        val (s01, g01) = minMax(a, b) // 1
        val (s02, g02) = minMax(c, d) // 2
        val (s03, g03) = minMax(s01, s02) // 3
        val (s, _) = minMax(s03, e)

        return if (s == e) {
            if (comp(g01, g02) == 1) {
                // 残りは g02, s01, s02
                listOf(e) + sort(listOf(g02, s01, s02)) + listOf(g01)
            } else {
                // 残りは g01, s01, s02
                listOf(e) + sort(listOf(g01, s01, s02)) + listOf(g02)
            }
        } else {
            // 残りは e, g01, g02, g03
            val (s11, g11) = minMax(g01, g02) // 4
            val (_, g) = minMax(g11, e) // 5
            if (e == g) {
                // g01, g02 はすでに計算しているので、 +2 でおわる
                listOf(s03) + sort(listOf(g01, g02, g03)) + listOf(e)
            } else {
                // s11 = g01 || g02
                listOf(s03) + sort(listOf(s11, g03, e)) + listOf(g11)
            }
        }
    }

    private fun sort(list: List<Char>): List<Char> {
        return list.sortedWith(Comparator { a, b -> comp(a, b) })
    }

    private fun minMax(a: Char, b: Char): Pair<Char, Char> {
        if (comp(a, b) == -1) {
            return a to b
        } else {
            return b to a
        }
    }

    private fun comp(a: Char, b: Char): Int {
        val comp = cache.get(a, b)
        if (comp != null) {
            log("use cache")
            return comp
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
            return comp2
        }
    }
}

fun main() {
    B(false).solve()
}