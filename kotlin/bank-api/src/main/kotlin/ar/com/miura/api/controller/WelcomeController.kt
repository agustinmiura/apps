package ar.com.miura.api.controller

import org.springframework.context.annotation.ComponentScan
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ComponentScan("ar.com.miura.api.controller")
class WelcomeController {

    @GetMapping("/welcome")
    fun sayHello():String {
        return "Welcome to an unsecured endpoint"
    }

}