package ar.com.miura.unitetesting.service

import ar.com.miura.unitetesting.domain.Item
import ar.com.miura.unitetesting.repository.ItemRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*


@ExtendWith(MockitoExtension::class)
class ItemServiceTestCase {

    @Mock
    lateinit var repository: ItemRepository

    @InjectMocks
    lateinit var business: SimpleItemService

    @Test
    fun shouldGetAll() {
        `when`(repository.findAll()).thenReturn(Arrays.asList(Item(2, "Item2", 10, 10),
                Item(3, "Item3", 20, 20)))
        val items: List<Item> = business.getAll()

        assertEquals(100, items[0].value)
        assertEquals(400, items[1].value)
    }

}