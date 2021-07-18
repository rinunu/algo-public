package aoj.itp1

import captureStdio
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://onlinejudge.u-aizu.ac.jp/problems/ITP1_7_B
 */
class ITP1_7_BTest {
    private fun test() = ITP1_7_B().solve()

    @Test
    fun p1() {
        val res = captureStdio(
            """
                5 9
                0 0
                """.trimIndent()
        ) {
            test()
        }
        assertEquals(
            """
            2
            
            """.trimIndent(), res
        )
    }

    @Test
    fun p2() {
        val res = captureStdio(
            """
                5 9
                3 3
                0 0
                """.trimIndent()
        ) {
            test()
        }
        assertEquals(
            """
            2
            0
            
        """.trimIndent(), res
        )
    }
}