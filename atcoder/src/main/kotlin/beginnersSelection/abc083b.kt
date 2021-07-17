package beginnersSelection

class Abc083B(private val logging: Boolean = true) {
    fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val (n, a, b) = readLine()!!.split(" ").map { it.toInt() }
        log("$n, $a, $b")
        val s1 = (1..n).map {
            it to calc(it)
        }

        log(s1)
        val s2 = s1.filter { it.second in a..b }
        log(s2)
        print(s2.map { it.first }.sum())
    }

    /**
     * 楽したパターン
     */
    fun calc1(x: Int): Int {
        val a = x.toString().map { it.toString().toInt() }
        return a.sum()
    }

    /**
     * ちゃんとやる
     */
    fun calc(x: Int): Int {
        var x2 = x
        // 下位桁から処理
        var sum = 0
        while (x2 > 0) {
            sum += x2 % 10
            x2 /= 10
        }
        return sum
    }
}


fun main() {
    Abc083B(false).solve()
}
