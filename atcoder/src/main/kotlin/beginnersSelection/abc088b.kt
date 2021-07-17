package beginnersSelection

class Abc088B(private val logging: Boolean = true) {
    private fun log(a: Any) {
        if (logging) {
            System.err.println(a)
        }
    }

    fun solve() {
        val n = readLine()!!.toInt()
        val items = readLine()!!.split(" ").map { it.toInt() }

        // a, b, a, b という順でとるから、ソートして、交互にとって、その差異かな?
        // 制約も難しい制約はついていない

        log(items)
        val sorted = items.sortedDescending()

        val a = sorted.filterIndexed { i, _ -> i % 2 == 0 }
        log(a)

        val b = sorted.filterIndexed { i, _ -> i % 2 == 1 }
        log(b)

        print(a.sum() - b.sum())
    }
}

fun main() {
    Abc088B(false).solve()
}


