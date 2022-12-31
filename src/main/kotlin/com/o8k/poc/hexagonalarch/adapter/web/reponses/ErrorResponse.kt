package com.o8k.poc.hexagonalarch.adapter.web.reponses

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ErrorResponse(
    var httpCode: Int,
    var message: String?,
    var internalCode: String,
    var errors: List<FieldErrorResponse>?
) {
    data class FieldErrorResponse(
        var message: String,
        var field: String
    )
}