package beginnersSelection

class Abc049C(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val words = listOf("dream", "dreamer", "erase", "eraser")
        // dream dreamer erase eraser
        // 4 パターン
        // O(4^n) ; n <= 10^5
        // 愚直にやると終わらない
        //
        // 逆に結果から取り除いていくと
        // O(n) くらいで終わりそう
        //
        // 頭から取り除いていくと、色んなバリエーションに該当しちゃう
        // dreamer を dream | dreamer どっちをとればいいかわからない
        // なので、末尾から取る
        var s = readLine()!!
        while (true) {
            val prev = s
            for (word in words) {
                s = s.removeSuffix(word)
            }
            if (prev == s) {
                break
            }
        }
        print(
            if (s.isEmpty()) {
                "YES"
            } else {
                "NO"
            }
        )
    }
}

fun main() {
    Abc049C(false).solve()
}