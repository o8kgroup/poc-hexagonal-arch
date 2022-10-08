package com.o8k.poc.hexagonalarch.domain.student

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class StudentUnitTest {
    @Test
    fun `should validate itself`() {
        // Arrange
        val student = Student("abc", "Student test")

        // Act and Assert
        assertTrue(student.isValid())
    }

    @Test
    fun `should fail when not valid`() {
        // Arrange
        val student = Student("abc", "")

        // Act and Assert
        assertFalse(student.isValid())
    }
}