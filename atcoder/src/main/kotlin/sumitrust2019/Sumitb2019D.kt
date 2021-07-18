package sumitrust2019

class Sumitb2019D(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val n = readLine()!!.toInt()
        val s = readLine()!!
        print(solve1(n, s))
    }

    fun solve1(n: Int, s: String): Int {
        val digits = s.toList().map { it.toString().toInt() }
            .toIntArray()
        log(digits.toList())
        // 全探索
        // S の N 桁から 3 つ選ぶ
        // N <= 30000
        // 全探索は無理
        // 2重ループも厳しい
        // 10 文字種しかないことを利用できないかな?
        // 10^3 ループにできそう
        // 最初の文字 a を決める
        // 次の文字は a よりもっとも右にあるもの

        var res = 0
        for (a in 0..9) {
            val ia = digits.indexOf(a)
            if (ia == -1 || ia > digits.size - 1 - 2) {
                continue
            }

            for (b in 0..9) {
                val ib = digits.indexOf(ia + 1, b)

                if (ib == -1 || ib > digits.size - 1 - 1) {
                    continue
                }

                for (c in 0..9) {
                    val ic = digits.indexOf(ib + 1, c)
                    if (ic == -1) {
                        continue
                    }

                    log("$a $b $c ($ia $ib $ic)")
                    // 重複は排除される。
                    // なぜならそもそも重複しないループになっているから
                    res++
                }
            }
        }

        return res
    }
}

fun main() {
    Sumitb2019D(false).solve()
}

fun IntArray.indexOf(start: Int, v: Int): Int {
    for (i in start until this.size) {
        if (this[i] == v) {
            return i
        }
    }
    return -1
}