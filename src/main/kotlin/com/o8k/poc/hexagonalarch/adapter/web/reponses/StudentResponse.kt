package com.o8k.poc.hexagonalarch.adapter.web.reponses

import com.o8k.poc.hexagonalarch.domain.student.Student

data class StudentResponse(
    var id: String = "",
    var name: String = ""
)

fun Student.toStudentResponse() = StudentResponse(
    id = id!!,
    name = name
)