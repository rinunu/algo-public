package beginnersSelection

import TestUtil
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * https://atcoder.jp/contests/abs/tasks/practice_1
 */
class TutorialKtTest {
    @Test
    fun p1() {
        val res = TestUtil.testWithStdio(
            """
                1
                2 3
                test
            """.trimIndent()
        ) {
            tutorial()
        }
        assertEquals(
            """
            6 test
            
        """.trimIndent(), res
        )
    }
}
