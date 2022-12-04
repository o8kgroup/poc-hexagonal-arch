package com.o8k.poc.hexagonalarch.domain.enums

enum class ErrorCodes(val code:String, val msg:String) {
    HEX001("HEX-001", "%s not found!"),
    HEX002("HEX-002", "%s Invalid operation!")
}