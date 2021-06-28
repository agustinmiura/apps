package ar.com.miura.unitetesting.repository

import ar.com.miura.unitetesting.domain.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository:JpaRepository<Item, Int> {
}