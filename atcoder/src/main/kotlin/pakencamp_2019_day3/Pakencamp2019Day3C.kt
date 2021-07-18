package pakencamp_2019_day3

import kotlin.math.max

private fun readIntArray(): IntArray {
    return readLine()!!.split(" ").map { it.toInt() }
        .toIntArray()
}

class Pakencamp2019Day3C(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    /**
     * 246 ms
     *
     * IntArray
     */
    fun solve() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        // nMList[n][m]
        val nMList = Array(n) {
            readIntArray()
        }

        print(solve1(n, m, nMList))
    }

//    fun solve11() {
//        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
//        // nMList[n][m]
//        val nMList = List(n) {
//            readLine()!!.split(" ").map { it.toInt() }
//        }
//
//        print(solve1(n, m, nMList))
//    }

    private fun solve1(n: Int, m: Int, nMList: Array<IntArray>): Long {
        // t1, t2 全探索
        // 生徒数分ループ
        // O(n3) n, m <= 100 だからいけそうでは?

        log("$n $m")

        var maxSum = 0L
        for (t1 in 0 until m) {
            for (t2 in (t1 + 1) until m) {
                log("$t1 $t2")

                var sum = 0L
                for (s in 0 until n) {
                    log("$s")
                    sum += max(nMList[s][t1], nMList[s][t2])
                }
                maxSum = maxSum.coerceAtLeast(sum)
            }
        }
        return maxSum
    }
}

fun main() {
    Pakencamp2019Day3C(false).solve()
}