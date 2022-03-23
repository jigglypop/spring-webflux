package com.example.content.handler

import com.example.content.entity.Test
import com.example.content.repository.TestRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class TestHandler {
    val testRepository: TestRepository
    constructor(testRepository: TestRepository) {
        this.testRepository = testRepository
    }

    fun readTests(req: ServerRequest) : Mono<ServerResponse> {
        return testRepository
            .findAll()
            .collectList()
            .flatMap { it ->
                ServerResponse.ok().body(BodyInserters.fromValue(it))
            }
    }

    fun readTest(req: ServerRequest) : Mono<ServerResponse> {
        return testRepository
            .findById(req.pathVariable("id").toInt())
            .flatMap { it ->
                ServerResponse.ok().body(BodyInserters.fromValue(it))
            }
    }

    fun createTest(req: ServerRequest) : Mono<ServerResponse> {
        return req.bodyToMono(Test::class.java)
            .flatMap { it -> testRepository.save(it) }
            .flatMap { it ->
                ServerResponse.ok().body(BodyInserters.fromValue(it))
            }
    }

    fun putTest(req: ServerRequest) : Mono<ServerResponse> {
        return req.bodyToMono(Test::class.java)
            .flatMap { it -> testRepository.save(Test(req.pathVariable("id").toInt(), it.name)) }
            .flatMap { it ->
                ServerResponse.ok().body(BodyInserters.fromValue(it))
            }
    }

    fun deleteTest(req: ServerRequest) : Mono<ServerResponse> {
        return testRepository
            .delete(Test(id = req.pathVariable("id").toInt()))
            .flatMap {
                ServerResponse.ok().body(BodyInserters.fromValue(
                    "삭제 완료"
                ))
            }
    }
}