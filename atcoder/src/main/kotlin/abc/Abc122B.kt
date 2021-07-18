package abc

class Abc122B(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val s = readLine()!!

        print(solve2(s))
    }

    fun solve1(s: String): Int {
        // ACGT 以外を置換, split し、一番長いのでいい?
        // O(n)?

        val s2 = s.replace("[^ACGT]".toRegex(), "@")
        val s3 = s2.split("@")
        log(s3)
        val s4 = s3.maxBy { it.length }!!
        return s4.length
    }

    fun solve2(s: String): Int {
        // 連続する ACGT の長さを測る
        // O(n)
        fun isAcgt(c: Char): Boolean {
            return c == 'A' || c == 'C' || c == 'G' || c == 'T'
        }

        var max = 0;
        var cnt = 0
        for (c in s) {
            if (isAcgt(c)) {
                cnt++
            } else {
                max = cnt.coerceAtLeast(max)
                cnt = 0
            }
        }
        max = cnt.coerceAtLeast(max)
        return max
    }
}

fun main() {
    Abc122B(false).solve()
}