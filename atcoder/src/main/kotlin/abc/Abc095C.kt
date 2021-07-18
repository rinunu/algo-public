package abc

class Abc095C(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val (a, b, c, x, y) = readLine()!!.split(" ").map { it.toInt() }
        log("$a $b $c $x $y")
        print(solve1(a, b, c, x, y))
    }

    private fun solve1(a: Int, b: Int, c: Int, x: Int, y: Int): Int {
        // 全探索
        // x, y <= 10^5 なので、2重ループでも全探索はきびしそう
        //
        // ab ピザだけループして、残りを a, b で埋めると言う考え方でいけそう?
        val abMax = x.coerceAtLeast(y)
        var minPrice = Int.MAX_VALUE
        for (numAb in 0..abMax) { // ab を フルサイズで言うところの何枚分買うか
            val numA = (x - numAb).coerceAtLeast(0)
            val numB = (y - numAb).coerceAtLeast(0)
            val price = a * numA + b * numB + c * 2 * numAb
            minPrice = minPrice.coerceAtMost(price)
        }
        return minPrice
    }
}

fun main() {
    Abc095C(false).solve()
}