package ar.com.miura.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContactController {
    @GetMapping("/contact")
    fun saveContactInquiryDetails(input: String?): String {
        return "Inquiry details are saved to the DB"
    }
}
