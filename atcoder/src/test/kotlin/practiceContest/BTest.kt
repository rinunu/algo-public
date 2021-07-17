package practiceContest

import interactive
import org.junit.jupiter.api.Test

/**
 * https://atcoder.jp/contests/practice/tasks/practice_2
 */
class BTest {
    private fun test() = B().solve()

    @Test
    fun p1() {
        interactive(
            this::test,
            initialInput = "3 10",
            expected = "! BAC"
        ) {
            when (it) {
                "? B A" -> "<"
                "? A B" -> ">"
                "? C B" -> ">"
                "? A C" -> "<"
                "? C A" -> ">"
                else -> TODO(it)
            }
        }
    }

    @Test
    fun p2() {
        interactive(
            this::test,
            initialInput = "5 7",
            expected = "! BACDE"
        ) {
            when (it) {
                "? B A" -> "<"
                "? A B" -> ">"
                "? C B" -> ">"
                "? A C" -> "<"
                "? C A" -> ">"
                "? D A" -> ">"
                "? D C" -> ">"
                "? E C" -> ">"
                "? E D" -> ">"
                else -> TODO(it)
            }
        }
    }
}