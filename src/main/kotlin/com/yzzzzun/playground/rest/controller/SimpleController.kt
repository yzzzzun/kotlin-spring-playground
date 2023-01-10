package com.yzzzzun.playground.rest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController {

    @GetMapping("/")
    fun index(): List<Message> {
        return listOf(
            Message(1L, "Hello"),
            Message(2L, "Bonjour"),
            Message(3L, "Privet")
        )
    }

    data class Message(val id: Long?, val message: String?)
}
