package nh.kong.post.services

import com.nh.util.ServiceUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PostServiceImpl(@Autowired private val serviceUtil: ServiceUtil){

    @GetMapping("/post/{postId}")
    fun getPost(@PathVariable postId: Int) : String {
        return serviceUtil.getServiceFullAddress()
    }
}