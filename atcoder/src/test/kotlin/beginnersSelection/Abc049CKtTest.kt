package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/arc065_a
 */
class Abc049CKtTest {
    private fun test() = Abc049C().solve()

    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """erasedream""".trimIndent()
        ) {
            test()
        }
        assertEquals("YES", res)
    }

    @Test
    fun p2() {
        val res = TestUtil.testWithStdio(
            """dreameraser""".trimIndent()
        ) {
            test()
        }
        assertEquals("YES", res)
    }

    @Test
    fun p3() {
        val res = TestUtil.testWithStdio(
            """dreamerer""".trimIndent()
        ) {
            test()
        }
        assertEquals("NO", res)
    }
}