package ar.com.miura.api.domain

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="account_transactions")
class AccountTransactions {

    @Id
    @Column(name = "transaction_id")
    var transactionId:String = ""

    @Column(name="account_number")
    var accountNumber:Long = -1

    @Column(name = "customer_id")
    private val customerId = 0

    @Column(name = "transaction_dt")
    private val transactionDt: LocalDate? = null

    @Column(name = "transaction_summary")
    private val transactionSummary: String? = null

    @Column(name = "transaction_type")
    private val transactionType: String? = null

    @Column(name = "transaction_amt")
    private val transactionAmt = 0

    @Column(name = "closing_balance")
    private val closingBalance = 0

    @Column(name = "create_dt")
    private val createDt: String? = null
}