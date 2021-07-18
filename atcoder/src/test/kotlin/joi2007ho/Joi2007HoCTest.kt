package joi2007ho

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class Joi2007HoCTest {
    private fun test() = Joi2007HoC().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """
                10
                9 4
                4 3
                1 1
                4 2
                2 4
                5 8
                4 0
                5 3
                0 5
                5 2
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("10", res)
    }
}