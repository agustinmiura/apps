package ar.com.miura.unitetesting.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Transient;

@Entity
class Item {

    constructor(id:Int, name:String, price:Int, quantity:Int) {
        this.id = id
        this.name = name
        this.price = price
        this.quantity = quantity
    }

    constructor(): this(0, "", 0, 0)

    @Id
    var id:Int = 0

    var name:String = ""

    var price:Int = -1

    var quantity:Int = 0

    @Transient
    var value:Int = 0

    override fun toString():String {
        return String.format("Item[%d,%s,%d,%d]", id, name, price, quantity)
    }
}