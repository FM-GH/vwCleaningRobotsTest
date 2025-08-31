package utils

import org.junit.jupiter.api.Assertions.*

class ValidateIfItsValidPositionTest {
    @org.junit.jupiter.api.Test
    fun validateIfItsValidPosition() {
        val resultTrue: Boolean =
            validateIfItsValidPosition(listOf(1,1), listOf(5,5), 1, 5)
        assertTrue { resultTrue }

        val resultFalse: Boolean =
            validateIfItsValidPosition(listOf(0,0), listOf(5,5), 6, 5)
        assertFalse { resultFalse }

    }

}