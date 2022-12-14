package com.o8k.poc.hexagonalarch.adapter.dbs.postgre

import com.o8k.poc.hexagonalarch.domain.student.Student
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import org.springframework.data.repository.findByIdOrNull
import javax.inject.Named

@Named
class StudentPersistenceImpl(
    private val studentRepository: StudentRepository
): StudentPersistenceInterface {
    override fun save(student: Student): Student {
        return studentRepository.save(student.toModel())
            .toStudent()
    }

    override fun findById(id: String): Student? {
        return studentRepository.findByIdOrNull(id)
            ?.toStudent()
    }
}