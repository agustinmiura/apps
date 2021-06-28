package ar.com.miura.unitetesting.controller

import ar.com.miura.unitetesting.domain.Item
import ar.com.miura.unitetesting.service.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController constructor(
    @Autowired val itemService: ItemService) {

    @GetMapping("/items")
    fun getItems():Item {
        return Item(1, "Ball", 10, 100)
    }

    @GetMapping("/service/items")
    fun getItemsFromService():Item {
        return itemService.getItem()
    }

    @GetMapping("/service/items/db")
    fun getItemsFromDb():List<Item> {
        return itemService.getAll()
    }


}