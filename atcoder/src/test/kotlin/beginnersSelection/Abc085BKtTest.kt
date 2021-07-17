package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc085_b
 */
class Abc085BKtTest {
    private fun test() = Abc085B().solve()

    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """
                4
                10
                8
                8
                6
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("3", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """
                3
                15
                15
                15
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("1", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """
                7
                50
                30
                50
                100
                50
                80
                30
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("4", res)
    }
}

