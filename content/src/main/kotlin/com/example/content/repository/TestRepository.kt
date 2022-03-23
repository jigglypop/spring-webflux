package com.example.content.repository

import com.example.content.entity.Test
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TestRepository: ReactiveCrudRepository<Test, Int> {
}