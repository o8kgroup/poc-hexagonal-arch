package com.o8k.poc.hexagonalarch.domain.student.ports.output

import com.o8k.poc.hexagonalarch.domain.student.Student

interface StudentPersistenceInterface {
    fun save(student: Student): Student
}