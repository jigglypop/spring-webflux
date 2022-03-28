package com.nh.api.core.post

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface PostService {

    @GetMapping("/post/{postId}", *["application/json"])
    fun getPost(@PathVariable postId: Int) : Post
}