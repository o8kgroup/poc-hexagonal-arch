package com.o8k.poc.hexagonalarch.domain.student.ports.output

import com.o8k.poc.hexagonalarch.domain.BaseDatabaseIntegrationTest
import com.o8k.poc.hexagonalarch.domain.student.Student
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class StudentPersistenceIntegrationTest: BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var studentPersistence: StudentPersistenceInterface

    @Test
    fun `should persist a student`() {
        // Arrange
        val studentToSave = Student("abc", "Student Test")

        // Act
        val savedStudent = studentPersistence.save(studentToSave)

        // Assert
        Assertions.assertEquals(studentToSave, savedStudent)
    }

    @Test
    fun `should find a student by id`() {
        // Arrange
        val studentToSave = Student("abc", "Student Test")
        studentPersistence.save(studentToSave)

        // Act
        val studentFound = studentPersistence.findById("abc")

        // Assert
        Assertions.assertEquals(studentToSave, studentFound)
    }
}