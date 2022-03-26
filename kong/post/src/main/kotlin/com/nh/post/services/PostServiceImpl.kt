package com.nh.post.services

import com.nh.api.core.post.Post
import com.nh.util.http.ServiceUtil

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PostServiceImpl {
    val serviceUtil: ServiceUtil
    constructor(serviceUtil: ServiceUtil) {
        this.serviceUtil = serviceUtil
    }

    @GetMapping("/post/{postId}")
    fun getPost(@PathVariable postId: Int) : Post {
        return Post(postId, "name-$postId", "컨텐츠", serviceUtil.getServiceFullAddress())
    }
}