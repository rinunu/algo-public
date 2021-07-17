package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc083_b
 */
class Abc083BKtTest {
    fun test() = Abc083B().solve()

    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """20 2 5""".trimIndent()
        ) {
            test()
        }
        assertEquals("84", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """10 1 2""".trimIndent()
        ) {
            test()
        }
        assertEquals("13", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """100 4 16""".trimIndent()
        ) {
            test()
        }
        assertEquals("4554", res)
    }
}

