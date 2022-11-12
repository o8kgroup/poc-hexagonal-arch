package com.o8k.poc.hexagonalarch.domain.student.ports.input

import com.o8k.poc.hexagonalarch.domain.student.Student

interface CreateStudentUseCaseInterface {
    fun save(student: Student): Student
}