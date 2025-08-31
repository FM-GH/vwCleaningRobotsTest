package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VerifyIntValuesTest {
    @Test
    fun verifyIntValues() {
        val resultTrue: Boolean = verifyIntValues(1) // true
        val resultFalse: Boolean = verifyIntValues("B") // false
        assertTrue { resultTrue }
        assertFalse { resultFalse }
    }

}