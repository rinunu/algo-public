package pakencamp_2019_day3

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class Pakencamp2019Day3CTest {
    private fun test() = Pakencamp2019Day3C().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """
                1 2
                80 84
            """.trimIndent()
        ) {
            test()
        }
        assertEquals("84", res)
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """
                3 4
                37 29 70 41
                85 69 76 50
                53 10 95 100
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("250", res)
    }
}