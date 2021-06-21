package ar.com.miura.auth2.controller

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/")
    fun main(token: OAuth2AuthenticationToken):String {
        return "secure.html";
    }

}