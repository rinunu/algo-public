package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/abc085_c
 */
class Abc085CKtTest {
    private fun test() = Abc085C().solve()

    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """9 45000""".trimIndent()
        ) {
            test()
        }
        assertEquals("0 9 0", res)
//        assertEquals("4 0 5", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """20 196000""".trimIndent()
        ) {
            test()
        }
        assertEquals("-1 -1 -1", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """1000 1234000""".trimIndent()
        ) {
            test()
        }
        assertEquals("2 54 944", res)
//        assertEquals("14 27 959", res)
    }

    @Test
    fun p4() {
        val res = TestUtil.testWithStdio(
            """2000 20000000""".trimIndent()
        ) {
            test()
        }
        assertEquals("2000 0 0", res)
    }
}

