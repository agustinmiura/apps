package ar.com.miura.mongodbapi.controller

import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class HelloControllerTestCase {
    @Test
    fun shouldCreateController() {
        var helloController = HelloController();
        assertThat(helloController, notNullValue())
    }
}