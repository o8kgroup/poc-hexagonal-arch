package com.o8k.poc.hexagonalarch.domain.student.usecase

import com.o8k.poc.hexagonalarch.domain.BaseDatabaseIntegrationTest
import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class FindStudentByIdIntegrationTest : BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseInterface

    @Autowired
    lateinit var studentData: StudentPersistenceInterface

    @Test
    fun `should find a student by id`() {
        // Arrange
        val studentToSave = Student("abc", "Student Test")
        studentData.save(studentToSave)

        // Act
        val savedStudent = findStudentByIdUseCase.findById("abc")

        // Assert
        Assertions.assertEquals(studentToSave, savedStudent)
    }
}