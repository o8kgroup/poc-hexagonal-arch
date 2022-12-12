package com.o8k.poc.hexagonalarch.templates

class StudentRequestsTemplate {
    companion object {
        fun buildCreateRequest(): String {
            return """ {"name": "Student Test"} """
        }
    }
}