package com.o8k.poc.hexagonalarch.adapter.web.advice

import com.o8k.poc.hexagonalarch.adapter.web.reponses.ErrorResponse
import com.o8k.poc.hexagonalarch.domain.student.exceptions.InvalidStudentException
import com.o8k.poc.hexagonalarch.domain.student.exceptions.StudentNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(StudentNotFoundException::class)
    fun handleStudentNotFoundException(
        ex: StudentNotFoundException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(InvalidStudentException::class)
    fun handleStudentInvalidException(ex: InvalidStudentException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}