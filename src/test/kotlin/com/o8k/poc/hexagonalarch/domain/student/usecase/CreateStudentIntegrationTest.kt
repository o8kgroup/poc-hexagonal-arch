package com.o8k.poc.hexagonalarch.domain.student.usecase

import com.o8k.poc.hexagonalarch.domain.BaseDatabaseIntegrationTest
import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.ports.input.CreateStudentUseCaseInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CreateStudentIntegrationTest : BaseDatabaseIntegrationTest() {
    @Autowired
    lateinit var createStudentUseCase: CreateStudentUseCaseInterface

    @Test
    fun `should create a student`() {
        // Arrange
        val studentToSave = Student("abc", "Student Test")

        //Act
        val savedStudent = createStudentUseCase.save(studentToSave)

        // Assert
        Assertions.assertEquals(studentToSave, savedStudent)
    }
}