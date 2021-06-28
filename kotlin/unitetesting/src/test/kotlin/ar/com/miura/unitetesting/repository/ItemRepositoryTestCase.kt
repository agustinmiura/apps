package ar.com.miura.unitetesting.repository

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ItemRepositoryTestCase {

    @Autowired
    private lateinit var repository:ItemRepository

    @Test
    fun shouldFindAll() {
        val items = repository.findAll()
        assertEquals(3,items.size);
    }

    @Test
    fun shouldFindOne() {
        val id: Int = 10001
        val item = repository.findById(id).get()
        assertEquals("Item1",item.name);
    }

}