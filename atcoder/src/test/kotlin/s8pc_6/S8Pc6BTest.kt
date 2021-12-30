package s8pc_6

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 */
class S8Pc6BTest {
    private fun test() = S8Pc6B().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """
                3
                5 7
                2 6
                8 10
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("18", res)
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """
                5
                1 71
                43 64
                13 35
                14 54
                79 85
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("334", res)
    }

    @Test
    fun p3() {
        val res = captureStdio(
            """
                11
                15004200 341668840
                277786703 825590503
                85505967 410375631
                797368845 930277710
                90107929 763195990
                104844373 888031128
                338351523 715240891
                458782074 493862093
                189601059 534714600
                299073643 971113974
                98291394 443377420
                """.trimIndent()
        ) {
            test()
        }
        assertEquals("8494550716", res)
    }
}