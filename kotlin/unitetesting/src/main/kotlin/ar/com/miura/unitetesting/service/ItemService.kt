package ar.com.miura.unitetesting.service

import ar.com.miura.unitetesting.domain.Item

public interface ItemService {
    fun getItem(): Item
    fun getAll():List<Item>
}