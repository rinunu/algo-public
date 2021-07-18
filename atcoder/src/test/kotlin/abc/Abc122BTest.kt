package abc

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class Abc122BTest {
    private fun test() = Abc122B().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """ATCODER""".trimIndent()
        ) {
            test()
        }
        assertEquals("3", res)
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """HATAGAYA""".trimIndent()
        ) {
            test()
        }
        assertEquals("5", res)
    }

    @Test
    fun p3() {
        val res = captureStdio(
            """SHINJUKU""".trimIndent()
        ) {
            test()
        }
        assertEquals("0", res)
    }

    @Test
    fun p4() {
        val res = captureStdio(
            """AOAAAAOAAAO""".trimIndent()
        ) {
            test()
        }
        assertEquals("4", res)
    }

    @Test
    fun p5() {
        val res = captureStdio(
            """A""".trimIndent()
        ) {
            test()
        }
        assertEquals("1", res)
    }
}