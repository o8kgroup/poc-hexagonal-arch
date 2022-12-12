package com.o8k.poc.hexagonalarch.adapter.web.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.o8k.poc.hexagonalarch.adapter.web.BaseWebIntegrationTest
import com.o8k.poc.hexagonalarch.adapter.web.reponses.StudentResponse
import com.o8k.poc.hexagonalarch.domain.student.ports.output.StudentPersistenceInterface
import com.o8k.poc.hexagonalarch.templates.StudentRequestsTemplate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class StudentControllerIntegrationTest : BaseWebIntegrationTest() {
    companion object {
        const val BASE_URL: String = "/student-management/v1/students"
    }

    @Autowired
    lateinit var studentData: StudentPersistenceInterface

    private val objectMapper = ObjectMapper()

    @Test
    fun `should save a student`() {
        // Arrange
        val body = StudentRequestsTemplate.buildCreateRequest()

        // Act
        val result = mvc.perform(
            post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
        )
            .andExpect(status().is2xxSuccessful)
            .andReturn()

        // Assert
        val studentResponse = objectMapper.readValue(result.response.contentAsString, StudentResponse::class.java)
        Assertions.assertEquals("Student Test", studentResponse.name)

        val savedStudent = studentData.findById(studentResponse.id)
        Assertions.assertEquals(studentResponse.id, savedStudent?.id)
    }
}