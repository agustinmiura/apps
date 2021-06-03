package ar.com.miura.mongodbapi.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    val logger: Logger = LoggerFactory.getLogger(HelloController::class.java)

    @GetMapping("/hello")
    fun helloMessage():String {
        logger.info("Sample logging")
        return "hello"
    }
}