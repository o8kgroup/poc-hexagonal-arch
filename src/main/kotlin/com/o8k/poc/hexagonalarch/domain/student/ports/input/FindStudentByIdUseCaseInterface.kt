package com.o8k.poc.hexagonalarch.domain.student.ports.input

import com.o8k.poc.hexagonalarch.domain.student.Student

interface FindStudentByIdUseCaseInterface {
    fun findById(id: String): Student
}