package com.o8k.poc.hexagonalarch.domain.student.usecase

import com.o8k.poc.hexagonalarch.domain.enums.ErrorCodes.HEX001
import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.exceptions.StudentNotFoundException
import com.o8k.poc.hexagonalarch.domain.student.ports.input.FindStudentByIdUseCaseInterface
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import javax.inject.Named

@Named
class FindStudentByIdUseCaseImpl(
    private val studentData: StudentPersistenceInterface
): FindStudentByIdUseCaseInterface {

    override fun findById(id: String): Student {
        return studentData.findById(id)
            ?: throw StudentNotFoundException(HEX001.msg.format("Student with id: $id"), HEX001.code)
    }
}