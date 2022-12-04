package com.o8k.poc.hexagonalarch.domain.student.usecase

import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.exceptions.InvalidStudentException
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateStudentUseCaseUnitTest {
    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var createStudentUseCase: CreateStudentUseCaseImpl

    @Test
    fun `should save a student`() {
        // Arrange
        val studentToSave = Student("abc", "Student Test")
        Mockito.`when`(studentPersistence.save(studentToSave)).then { studentToSave }

        //Act
        val result = createStudentUseCase.save(studentToSave)

        // Assert
        Assertions.assertEquals(studentToSave, result)
    }

    @Test
    fun `should throw exception when student not valid`() {
        // Arrange
        val studentToSave = Student("abc", "")

        //Act
        val exception =
            org.junit.jupiter.api.assertThrows<InvalidStudentException> { createStudentUseCase.save(studentToSave) }

        // Assert
        val expected = "Sorry, check the information provided. Invalid operation!"
        Assertions.assertEquals(expected, exception.message)
    }
}