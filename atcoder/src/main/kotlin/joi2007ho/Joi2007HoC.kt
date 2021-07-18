package joi2007ho

import kotlin.math.absoluteValue

class Joi2007HoC(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val n = readLine()!!.toInt()
        val posList = Array(n) {
            readIntArray()
        }
        print(solve1(n, posList))
    }

    private fun solve1(n: Int, posList: Array<IntArray>): Int {
        // 正方形とはなんなのか?
        // - 4辺の長さが同じ
        // - 同じ長さの対角線が中央で 90 度で交わる
        // - ついになる辺が並行
        //
        // 全探索
        // 4つの位置を選んで、それが正方形になっているかを調べる
        // n <= 3000
        // n^4 だと無理
        //
        // 直角とかをうまく使えないか?
        // 長さ?
        // 2つ点を選んで、長さを出しておく
        // n^2 なのでいける
        //
        // "2つの点" のペアごとに、それが正方形を作るかを調べる
        // < n^2 なのでいける

        // これで MLE しちゃう
        val posPairs = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until n) {
            for (j in (i + 1) until n) {
                posPairs += i to j
            }
        }

//        val len2Lines = posPairs.groupBy {
//            val a = posList[it.first]
//            val b = posList[it.second]
//            len2(a, b)
//        }
//
        var maxArea = 0
//        val lens = len2Lines.keys.sortedDescending()
//        for (len in lens) {
//            log("$len")
//            val lines = len2Lines[len]!!
//            for (iLineA in lines.indices) {
//                for (iLineB in (iLineA + 1) until lines.size) {
//                    val lineA = lines[iLineA]
//                    val lineB = lines[iLineB]
//                    val a1 = posList[lineA.first]
//                    val a2 = posList[lineA.second]
//                    val b1 = posList[lineB.first]
//                    val b2 = posList[lineB.second]
//                    if (isSameLengthAndParallel(a1, a2, b1, b2)) {
//                        log("ok ${a1.toList()}-${a2.toList()}  ${b1.toList()}-${b2.toList()}")
//                        val area = area(a1, a2)
//                        maxArea = area.coerceAtLeast(maxArea)
//                    }
//                }
//            }
////            log("$len $posPairs")
//            log("")
//        }
        return maxArea
    }

    /**
     * 長さが同じ & 並行
     */
    private fun isSameLengthAndParallel(
        a1: IntArray, a2: IntArray,
        b1: IntArray, b2: IntArray
    ): Boolean {

        if ((a1[0] - a2[0]) == (b1[0] - b2[0]) &&
            (a1[1] - a2[1]) == (b1[1] - b2[1])
        ) {
            return true
        }

        // 逆方向
        if ((a2[0] - a1[0]) == (b2[0] - b1[0]) &&
            (a1[1] - a2[1]) == (b1[1] - b2[1])
        ) {
            return true
        }

        return false
    }

    /**
     * 長さっぽいもの
     */
    private fun len2(a: IntArray, b: IntArray): Int {
        return (a[0] - b[0]).absoluteValue + (a[1] - b[1]).absoluteValue
    }

    /**
     * 一辺の情報を渡す
     */
    private fun area(a1: IntArray, a2: IntArray): Int {
        val x = (a1[0] - a2[0])
        val y = (a1[1] - a2[1])

        // ルートをとった後、2乗するので
        return x * x + y * y
    }
}

fun main() {
    Joi2007HoC(false).solve()
}


private fun readIntArray(): IntArray {
    return readLine()!!.split(" ").map { it.toInt() }
        .toIntArray()
}
