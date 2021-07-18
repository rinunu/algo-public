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
        println(solve2(n, posList))
    }

    private fun solve2(n: Int, posList: Array<IntArray>): Int {
        // 2つの点を選ぶ
        // その線を使って正方形になるものがあるかを探す

        // 最大 5000
        val x2PosIndexList = posList.mapIndexed { i, it ->
            i to it
        }.groupBy({
            it.second[0]
        }, {
            it.first
        })

        fun findPosIndex(x: Int, y: Int, posList: Array<IntArray>): Int {
            val posIndexList = x2PosIndexList[x]
                ?: return -1

            return posIndexList.indexOfFirst { i ->
                posList[i][0] == x && posList[i][1] == y
            }
        }

        var maxArea = 0
        for (ia1 in 0 until n) {
            for (ia2 in (ia1 + 1) until n) {
                val a1 = posList[ia1]
                val a2 = posList[ia2]
                val ax = a1[0] - a2[0]
                val ay = a1[1] - a2[1]

                val b1X = a1[0] + ay
                val b1Y = a1[1] - ax
                val b2X = a2[0] + ay
                val b2Y = a2[1] - ax

                log("$ax $ay")

                val ib1 = findPosIndex(b1X, b1Y, posList)
                if (ib1 != -1) {
                    val ib2 = findPosIndex(b2X, b2Y, posList)
                    if (ib2 != -1) {

                        maxArea = area(a1, a2).coerceAtLeast(maxArea)
                        log("ok! b ${a1.toList()} ${a2.toList()}")
                        continue
                    }
                }

                val c1X = a1[0] - ay
                val c1Y = a1[1] + ax
                val c2X = a2[0] - ay
                val c2Y = a2[1] + ax
                val ic1 = findPosIndex(c1X, c1Y, posList)
                if (ic1 != -1) {
                    val ic2 = findPosIndex(c2X, c2Y, posList)
                    if (ic2 != -1) {
                        maxArea = area(a1, a2).coerceAtLeast(maxArea)
                        log("ok! c ${a1.toList()} ${a2.toList()}")
                    }
                }
            }
        }
        return maxArea
    }

    private fun solve1(n: Int, posList: Array<IntArray>): Int {
        // メモリ制限が厳しい


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
//        val posPairs = mutableListOf<Pair<Int, Int>>()
//        for (i in 0 until n) {
//            for (j in (i + 1) until n) {
//                posPairs += i to j
//            }
//        }

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
