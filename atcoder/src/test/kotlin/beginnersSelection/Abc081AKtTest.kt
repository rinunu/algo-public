package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc081_a
 */
class Abc081AKtTest {
    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """101""".trimIndent()
        ) {
            abc081a()
        }
        assertEquals("2", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """000""".trimIndent()
        ) {
            abc081a()
        }
        assertEquals("0", res)
    }
}
