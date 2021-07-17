package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc088_b
 */
class Abc088BKtTest {
    private fun test() = Abc088B().solve()

    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """
                2
                3 1
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("2", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """
                3
                2 7 4
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("5", res)
    }


    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """
                4
                20 18 2 18
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("18", res)
    }
}

