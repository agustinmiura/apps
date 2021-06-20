package ar.com.miura.api.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Accounts {
    @Column(name = "customer_id")
    var customerId = 0

    @Column(name = "account_number")
    @Id
    var accountNumber: Long = 0

    @Column(name = "account_type")
    var accountType: String? = null

    @Column(name = "branch_address")
    var branchAddress: String? = null

    @Column(name = "create_dt")
    var createDt: String? = null
}
