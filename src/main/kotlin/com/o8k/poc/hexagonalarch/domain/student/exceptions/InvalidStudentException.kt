package com.o8k.poc.hexagonalarch.domain.student.exceptions

class InvalidStudentException(msg: String, val errorCode: String): RuntimeException(msg)