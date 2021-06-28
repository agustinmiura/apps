package ar.com.miura.unitetesting.spike

import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert

class JsonAssertTestCase {

    val actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    fun shouldAssertExactSpaces() {
        val expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10, \"quantity\":100}"
        JSONAssert.assertEquals(expectedResponse, actualResponse, true)
    }

    @Test
    fun shouldAssertWithStrictFalse() {
        val expectedResponse = "{\"id\": 1, \"name\":\"Ball\", \"price\":10}"
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    fun shouldAssertWithoutEscape() {
        val expectedResponse = "{id:1, name:Ball, price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

}