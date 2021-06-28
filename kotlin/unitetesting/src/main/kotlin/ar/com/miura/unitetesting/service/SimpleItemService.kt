package ar.com.miura.unitetesting.service

import ar.com.miura.unitetesting.domain.Item
import ar.com.miura.unitetesting.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SimpleItemService(@Autowired val itemRepository: ItemRepository):ItemService {
    override fun getItem():Item {
        return Item(1, "Ball", 10, 100)
    }
    override fun getAll(): List<Item> {
        val items = itemRepository.findAll()
        for(item in items) {
            item.value = item.price * item.quantity
        }
        return items
    }
}