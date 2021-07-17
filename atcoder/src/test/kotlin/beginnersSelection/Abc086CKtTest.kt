package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/arc089_a
 */
class Abc086CKtTest {
    private fun test() = Abc086C().solve()

    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """
                2
                3 1 2
                6 1 1
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("Yes", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """
                1
                2 100 100
            """.trimIndent()
        ) {
            test()
        }
        assertEquals("No", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """
                2
                5 1 1
                100 1 1
            """.trimIndent()
        ) {
            test()
        }
        assertEquals("No", res)
    }

    /**
     * オリジナル
     *
     * 3行程
     */
    @Test
    fun p4() {
        val res = TestUtil.testWithStdio(
            """
                3
                3 1 2
                6 1 1
                7 1 0
            """.trimIndent()
        ) {
            test()
        }
        assertEquals("Yes", res)
    }

    /**
     * オリジナル
     *
     * 3行程
     */
    @Test
    fun p5() {
        val res = TestUtil.testWithStdio(
            """
                3
                3 1 2
                6 1 1
                7 1 1
            """.trimIndent()
        ) {
            test()
        }
        assertEquals("No", res)
    }
}