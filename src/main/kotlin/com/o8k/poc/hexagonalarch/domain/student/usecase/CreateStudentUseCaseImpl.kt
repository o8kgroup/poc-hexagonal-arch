package com.o8k.poc.hexagonalarch.domain.student.usecase

import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.exceptions.InvalidStudentException
import com.o8k.poc.hexagonalarch.domain.student.ports.input.CreateStudentUseCaseInterface
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import javax.inject.Named

@Named
class CreateStudentUseCaseImpl(private val studentData: StudentPersistenceInterface) : CreateStudentUseCaseInterface {
    override fun save(student: Student): Student {
        if (!student.isValid()) {
            throw InvalidStudentException("Student is invalid")
        }
        return studentData.save(student)
    }

}