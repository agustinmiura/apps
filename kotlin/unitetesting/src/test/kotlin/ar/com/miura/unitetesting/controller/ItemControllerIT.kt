package ar.com.miura.unitetesting.controller

import org.json.JSONException
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment= RANDOM_PORT)
class ItemControllerIT {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(JSONException::class)
    fun contextLoads() {
        val response = restTemplate!!.getForObject("/service/items/db", String::class.java)
        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]",
                response, false)
    }

}