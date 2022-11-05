package com.o8k.poc.hexagonalarch.domain.student.usecase

import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class FindStudentByIdUseCaseUnitTest {
    @Mock
    lateinit var studentPersistence: StudentPersistenceInterface

    @InjectMocks
    lateinit var findStudentByIdUseCase: FindStudentByIdUseCaseImpl

    @Test
    fun `should find a student by id`() {
        // Arrange
        val student = Student("abc", "Student Test")

        Mockito.`when`(studentPersistence.findById("abc"))
            .then { student }

        // Act
        val result = findStudentByIdUseCase.findById("abc")

        // Assert
        Assertions.assertEquals(student, result)
    }
}