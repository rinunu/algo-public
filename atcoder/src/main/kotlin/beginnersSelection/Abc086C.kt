package beginnersSelection

import kotlin.math.absoluteValue

class Abc086C(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    data class A(val t: Int, val x: Int, val y: Int)

    fun solve() {
        solve1()
    }

    /**
     * 444 ms
     *
     * sequence
     */
    fun solve4() {
        // (x+1,y),(x−1,y),(x,y+1),(x,y−1)

        // 愚直に考えると、ta => tb が可能かを調べればいい
        // 全件調べるのは大変そう
        // 0,0 => 1,1 は 2, 4, 6, ... 回移動
        // 0,0 => 0,1 は 1, 3, 5, ... 回移動
        // 0,0 => 3,1 は 4, 6, 8, ... 回移動

        val r = System.`in`.bufferedReader()

        val n = r.readLine()!!.toInt()
        val items = listOf(A(0, 0, 0)) + List(n) {
            val (t, x, y) = r.readLine()!!.split(" ").map { it.toInt() }
            A(t, x, y)
        }
        log(items)
        val result = items.asSequence().windowed(2).all { (a, b) ->
            canMove(a, b)
        }
        if (result) {
            print("Yes")
        } else {
            print("No")
        }
    }

    /**
     * 333 ms (ちょい遅い)
     * パフォーマンス優先で書いてみた & 最初に全部読み込むようにしてみた
     */
    fun solve3() {
        // (x+1,y),(x−1,y),(x,y+1),(x,y−1)

        // 愚直に考えると、ta => tb が可能かを調べればいい
        // 全件調べるのは大変そう
        // 0,0 => 1,1 は 2, 4, 6, ... 回移動
        // 0,0 => 0,1 は 1, 3, 5, ... 回移動
        // 0,0 => 3,1 は 4, 6, 8, ... 回移動

        val r = System.`in`.bufferedReader()
        val lines = r.readLines()

        var lineNo = 1
        var prevT = 0
        var prevX = 0
        var prevY = 0
        while (true) {
            if (lineNo >= lines.size) {
                print("Yes")
                return
            }

            val line = lines[lineNo++]
            val (t, x, y) = line.split(" ").map { it.toInt() }
            val min = (prevX - x).absoluteValue + (prevY - y).absoluteValue

            val rest = (t - prevT) - min
            if (rest < 0 || rest % 2 == 1) {
                print("No")
                return
            }
            prevT = t
            prevX = x
            prevY = y
        }
    }

    /**
     * 293 ms
     *
     * パフォーマンス優先で書いてみた
     */
    fun solve2() {
        // (x+1,y),(x−1,y),(x,y+1),(x,y−1)

        // 愚直に考えると、ta => tb が可能かを調べればいい
        // 全件調べるのは大変そう
        // 0,0 => 1,1 は 2, 4, 6, ... 回移動
        // 0,0 => 0,1 は 1, 3, 5, ... 回移動
        // 0,0 => 3,1 は 4, 6, 8, ... 回移動

        val r = System.`in`.bufferedReader()

        r.readLine()!!.toInt()
        var prevT = 0
        var prevX = 0
        var prevY = 0
        while (true) {
            val line = r.readLine()
            if (line == null) {
                print("Yes")
                return
            }
            val (t, x, y) = line.split(" ").map { it.toInt() }
            val min = (prevX - x).absoluteValue + (prevY - y).absoluteValue

            val rest = (t - prevT) - min
            if (rest < 0 || rest % 2 == 1) {
                print("No")
                return
            }
            prevT = t
            prevX = x
            prevY = y
        }
    }

    /**
     * 384 ms
     */
    fun solve1() {
        // (x+1,y),(x−1,y),(x,y+1),(x,y−1)

        // 愚直に考えると、ta => tb が可能かを調べればいい
        // 全件調べるのは大変そう
        // 0,0 => 1,1 は 2, 4, 6, ... 回移動
        // 0,0 => 0,1 は 1, 3, 5, ... 回移動
        // 0,0 => 3,1 は 4, 6, 8, ... 回移動

        val r = System.`in`.bufferedReader()

        val n = r.readLine()!!.toInt()
        val items = listOf(A(0, 0, 0)) + List(n) {
            val (t, x, y) = r.readLine()!!.split(" ").map { it.toInt() }
            A(t, x, y)
        }
        log(items)
        val result = items.windowed(2).all { (a, b) ->
            canMove(a, b)
        }
        if (result) {
            print("Yes")
        } else {
            print("No")
        }
    }

    private fun canMove(a: A, b: A): Boolean {
        // 最低何歩で移動できるか
        val min = (a.x - b.x).absoluteValue + (a.y - b.y).absoluteValue
        // なん歩歩いたか
        val t = b.t - a.t
        val rest = t - min
        if (rest < 0) {
            return false
        }

        // 余分な歩数は偶数なら元の位置に戻ってこれる
        return rest % 2 == 0
    }
}

fun main() {
    Abc086C(false).solve()
}



