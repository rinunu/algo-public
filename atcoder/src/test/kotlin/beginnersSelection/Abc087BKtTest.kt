package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc087_b
 */
class Abc087BKtTest {
    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """
                2
                2
                2
                100
                """.trimIndent()
        ) {
            Abc087B().solve()
        }
        assertEquals("2", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """
                5
                1
                0
                150
                """.trimIndent()
        ) {
            Abc087B().solve()
        }
        assertEquals("0", res)
    }


    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """
                30
                40
                50
                6000
                """.trimIndent()
        ) {
            Abc087B().solve()
        }
        assertEquals("213", res)
    }
}

