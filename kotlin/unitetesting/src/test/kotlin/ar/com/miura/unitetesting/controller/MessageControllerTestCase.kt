package ar.com.miura.unitetesting.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(MessageController::class)
class MessageControllerTestCase {

    @Autowired lateinit var mockMvc: MockMvc

    @Test
    fun shouldReturnMessage() {
        val request = MockMvcRequestBuilders.get("/message")
            .accept(MediaType.APPLICATION_JSON)

        val result = mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().string("hello"))
        .andReturn()

        Assertions.assertEquals("hello", result.response.contentAsString)
    }

}