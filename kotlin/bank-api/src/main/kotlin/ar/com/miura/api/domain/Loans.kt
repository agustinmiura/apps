package ar.com.miura.api.domain

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name="loans")
class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_number")
    private val loanNumber = 0

    @Column(name = "customer_id")
    private val customerId = 0

    @Column(name = "start_dt")
    private val startDt: LocalDateTime = LocalDateTime.now()

    @Column(name = "loan_type")
    private val loanType: String? = null

    @Column(name = "total_loan")
    private val totalLoan = 0

    @Column(name = "amount_paid")
    private val amountPaid = 0

    @Column(name = "outstanding_amount")
    private val outstandingAmount = 0

    @Column(name = "create_dt")
    private val createDt: String = LocalDateTime.now().toString()


}