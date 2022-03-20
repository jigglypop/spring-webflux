package nh.yeeyee.service

import nh.yeeyee.entity.Post
import nh.yeeyee.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PostService(
    @Autowired val postRepository: PostRepository
) {

    @Transactional
    fun save(post:Post) = post.let {
        postRepository.save(it)
    }
}