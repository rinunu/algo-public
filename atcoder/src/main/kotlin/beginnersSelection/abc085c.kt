package beginnersSelection

class Abc085C(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val (n, y) = readLine()!!.split(" ").map { it.toInt() }
        // N
        // 3 種類
        // n^3 で n <= 2000 なので、全探索だとちょっと厳しい
        // 3重ループの最後は枚数が確定するので、 n^2 より小さくなるので、処理できそう
        val result = mutableListOf<List<Int>>()
        for (a10000 in 0..n) {
            val bMax = n - a10000 // これはやらなくても間にあう
            for (b5000 in 0..bMax) {
                val c1000 = n - a10000 - b5000
                if (a10000 * 10000 + b5000 * 5000 + c1000 * 1000 == y) {
                    result.add(listOf(a10000, b5000, c1000))
                }
            }
        }
        if (result.size == 0) {
            print("-1 -1 -1")
        } else {
            print(result.first().joinToString(" "))
        }
    }
}

fun main() {
    Abc085C(false).solve()
}



