package ar.com.miura.unitetesting.controller

import ar.com.miura.unitetesting.domain.Item
import ar.com.miura.unitetesting.service.ItemService
import org.assertj.core.util.Arrays
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(ItemController::class)
class ItemControllerTestCase {

    @MockBean
    @Autowired lateinit var itemService: ItemService

    @Autowired lateinit var mockMvc: MockMvc

    @Test
    fun shouldGetItem() {
        val request = MockMvcRequestBuilders.get("/items")
                .accept(MediaType.APPLICATION_JSON)

        val result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn()
    }

    @Test
    fun shouldGetItemFromService() {

        Mockito.`when`(itemService.getItem()).thenReturn(Item(2,"Item2",10,100))

        val request = MockMvcRequestBuilders.get("/service/items")
                .accept(MediaType.APPLICATION_JSON)

        val result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Item2\",\"price\":10,\"quantity\":100}"))
                .andReturn()
    }

    @Test
    fun shouldGetAllFromService() {

        val items:MutableList<Item> = mutableListOf()
        items.add(Item(2,"Item2", 10, 10))
        items.add(Item(3,"Item3", 10, 10))

        Mockito.`when`(itemService.getAll()).thenReturn(items)

        val request = MockMvcRequestBuilders.get("/service/items/db")
                .accept(MediaType.APPLICATION_JSON)

        val result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:3,name:Item3,price:10}, {id:2,name:Item2,price:10}]"))
                .andReturn()
    }

    @Test
    fun shouldWorkNoItems() {
        val items:MutableList<Item> = mutableListOf()

        Mockito.`when`(itemService.getAll()).thenReturn(items)

        val request = MockMvcRequestBuilders.get("/service/items/db")
                .accept(MediaType.APPLICATION_JSON)

        val result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andReturn()
    }

}