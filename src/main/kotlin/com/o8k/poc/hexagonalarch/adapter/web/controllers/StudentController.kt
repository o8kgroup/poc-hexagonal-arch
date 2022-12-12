package com.o8k.poc.hexagonalarch.adapter.web.controllers

import com.o8k.poc.hexagonalarch.adapter.web.reponses.StudentResponse
import com.o8k.poc.hexagonalarch.adapter.web.reponses.toStudentResponse
import com.o8k.poc.hexagonalarch.adapter.web.requests.CreateStudentRequest
import com.o8k.poc.hexagonalarch.domain.student.ports.input.CreateStudentUseCaseInterface
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student-management")
class StudentController(private val createStudentUseCase: CreateStudentUseCaseInterface) {

    @PostMapping("/v1/students")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateStudentRequest): StudentResponse =
        createStudentUseCase.save(request.toStudent())
            .toStudentResponse()
}