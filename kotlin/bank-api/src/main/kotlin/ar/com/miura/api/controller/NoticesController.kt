package ar.com.miura.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class NoticesController {

    @GetMapping("/notices")
    fun getNotices(input:String):String {
        return "From database notices"
    }

}