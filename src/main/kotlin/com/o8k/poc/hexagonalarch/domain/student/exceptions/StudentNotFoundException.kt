package com.o8k.poc.hexagonalarch.domain.student.exceptions

class StudentNotFoundException(msg: String, val errorCode: String): RuntimeException(msg)