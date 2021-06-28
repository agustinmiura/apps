package ar.com.miura.unitetesting.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {

    @GetMapping("/message")
    fun getMessage():String {
        return "hello"
    }
}