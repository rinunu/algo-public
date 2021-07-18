package abc

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class Abc095CTest {
    private fun test() = Abc095C().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """1500 2000 1600 3 2""".trimIndent()
        ) {
            test()
        }
        assertEquals("7900", res)
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """1500 2000 1900 3 2""".trimIndent()
        ) {
            test()
        }
        assertEquals("8500", res)
    }

    @Test
    fun p3() {
        val res = captureStdio(
            """1500 2000 500 90000 100000""".trimIndent()
        ) {
            test()
        }
        assertEquals("100000000", res)
    }
}