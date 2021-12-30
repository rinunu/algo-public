package s8pc_6


class S8Pc6B(private val logging: Boolean = true) {
    private fun log(f: () -> Any) {
        if (logging) {
            System.err.println(f())
        }
    }

    fun solve() {
    }

}

fun main() {
    S8Pc6B(false).solve()
}

