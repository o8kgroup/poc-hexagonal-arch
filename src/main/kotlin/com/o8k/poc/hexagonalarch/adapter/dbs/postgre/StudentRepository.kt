package com.o8k.poc.hexagonalarch.adapter.dbs.postgre

import org.springframework.data.jpa.repository.JpaRepository
import javax.inject.Named

@Named
interface StudentRepository: JpaRepository<StudentModel, String>