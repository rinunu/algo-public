package abc

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class Abc106BTest {
    private fun test() = Abc106B().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """105""".trimIndent()
        ) {
            test()
        }
        assertEquals("1", res)
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """7""".trimIndent()
        ) {
            test()
        }
        assertEquals("0", res)
    }
}