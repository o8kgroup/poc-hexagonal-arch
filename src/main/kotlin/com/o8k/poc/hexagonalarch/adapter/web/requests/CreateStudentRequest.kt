package com.o8k.poc.hexagonalarch.adapter.web.requests

import com.o8k.poc.hexagonalarch.domain.student.Student

data class CreateStudentRequest(
    var name: String
) {
    fun toStudent() = Student(
        name = name
    )
}