package com.o8k.poc.hexagonalarch.adapter.dbs.postgre

import com.o8k.poc.hexagonalarch.domain.student.Student
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "students")
data class StudentModel(
    @Id
    var id: String = "",
    @Column
    var name: String = ""
) {
    fun toStudent() = Student(
        id = id,
        name = name
    )
}

fun Student.toModel() = StudentModel(
    id = id ?: UUID.randomUUID().toString(),
    name = name
)