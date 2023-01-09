package com.yzzzzun.blog.controller

import com.yzzzzun.blog.domain.Message
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping("/")
    fun getMessages(): ResponseEntity<List<Message>> = ResponseEntity.ok(
        listOf(
            Message("1", "Hello!"),
            Message("2", "Bonjour!"),
            Message("3", "Privet!")
        )
    )
}
