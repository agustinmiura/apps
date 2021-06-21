package ar.com.miura.api.domain

import javax.persistence.*

@Entity
@Table(name = "authorities")
class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String? = null

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer? = null
}