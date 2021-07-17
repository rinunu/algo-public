package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc086_a
 */
class Abc086AKtTest {
    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """3 4""".trimIndent()
        ) {
            abc086a()
        }
        assertEquals("Even", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """1 21""".trimIndent()
        ) {
            abc086a()
        }
        assertEquals("Odd", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """10000 10000""".trimIndent()
        ) {
            abc086a()
        }
        assertEquals("Even", res)
    }
}
