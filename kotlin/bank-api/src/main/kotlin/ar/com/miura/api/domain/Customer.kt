package ar.com.miura.api.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    val id:Int = -1

    val name:String = ""

    val email:String = ""

    @Column(name = "mobile_number")
    private val mobileNumber = ""

    @JsonIgnore
    val pwd:String = ""

    val role:String = ""

    @Column(name = "create_dt")
    val createDt:String = LocalDateTime.now().toString()

}

