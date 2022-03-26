package com.server.user.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @RequestMapping("/")
    fun getUser() : String {
        return "user information"
    }
}