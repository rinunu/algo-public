package sumitrust2019

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class Sumitb2019DTest {
    private fun test() = Sumitb2019D().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """
                4
                0224
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("3", res)
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """
                6
                123123
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("17", res)
    }

    @Test
    fun p3() {
        val res = captureStdio(
            """
                19
                3141592653589793238
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("329", res)
    }

    /**
     * 重複するケース
     */
    @Test
    fun p4() {
        val res = captureStdio(
            """
                5
                11111
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("1", res)
    }
}