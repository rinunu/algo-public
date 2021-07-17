package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc081_b
 */
class Abc081BKtTest {
    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """
                3
                8 12 40
                """.trimIndent()
        ) {
            Abc081b().solve()
        }
        assertEquals("2", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """
                4
                5 6 8 10
                """.trimIndent()
        ) {
            Abc081b().solve()

        }
        assertEquals("0", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """
                6
                382253568 723152896 37802240 379425024 404894720 471526144
                """.trimIndent()
        ) {
            Abc081b().solve()
        }
        assertEquals("8", res)
    }

    @Test
    fun p4() {
        val res = TestUtil.testWithStdio(
            """
                1
                1
                """.trimIndent()
        ) {
            Abc081b().solve()
        }
        assertEquals("0", res)
    }
}
