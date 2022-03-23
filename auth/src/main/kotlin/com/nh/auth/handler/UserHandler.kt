package com.nh.auth.handler

import com.nh.auth.entity.User
import com.nh.auth.entity.UserForm
import com.nh.auth.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandler {
    var userRepository: UserRepository
    constructor(userRepository: UserRepository) {
        this.userRepository = userRepository
    }
    fun register(req: ServerRequest) : Mono<ServerResponse> {
        return req.bodyToMono(UserForm::class.java)
            .flatMap { it ->
                userRepository.save(User(
                    username = it.username,
                    hashedPassword = it.password,
                    email = it.email,
                    imageUrl =  it.imageUrl,
                    githubUrl = it.githubUrl,
                    summary = it.summary
                ))
            }
            .flatMap { it ->
                ServerResponse.ok().body(BodyInserters.fromValue(it))
            }
    }
}