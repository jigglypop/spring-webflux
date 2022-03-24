package nh.yeeyee.controller

import nh.yeeyee.entity.Post
import nh.yeeyee.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.servlet.http.HttpServletRequest

@RestController
class PostController (
    @Autowired private val postService: PostService
    )
{
    @PostMapping("/posts")
    fun createPost(@RequestBody post: Post, request: HttpServletRequest) : ResponseEntity<Any> {
        val id  = postService.save(post).id
        return ResponseEntity.created(URI.create("${request.requestURL}/$id")).build()
    }
}