package ar.com.miura.api.domain

import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = "cards")
class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private val cardId = 0

    @Column(name = "customer_id")
    private val customerId = 0

    @Column(name = "card_number")
    private val cardNumber: String? = null

    @Column(name = "card_type")
    private val cardType: String? = null

    @Column(name = "total_limit")
    private val totalLimit = 0

    @Column(name = "amount_used")
    private val amountUsed = 0

    @Column(name = "available_amount")
    private val availableAmount = 0

    @Column(name = "create_dt")
    private val createDt: LocalDate = LocalDate.now()

}