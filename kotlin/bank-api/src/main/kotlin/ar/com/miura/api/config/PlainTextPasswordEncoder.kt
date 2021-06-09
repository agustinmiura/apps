package ar.com.miura.api.config

import org.springframework.security.crypto.password.PasswordEncoder

class PlainTextPasswordEncoder : PasswordEncoder {
    override fun encode(password: CharSequence?): String {
        return password.toString()
    }

    override fun matches(password0: CharSequence?, password1: String?): Boolean {
        return if (password0 != null && password1!=null) {
            password0 == password1
        } else {
            false;
        }
    }
}