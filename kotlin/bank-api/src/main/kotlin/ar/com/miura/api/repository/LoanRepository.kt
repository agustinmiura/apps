package ar.com.miura.api.repository
import ar.com.miura.api.domain.Loans
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface LoanRepository : CrudRepository<Loans?, Long?> {
    fun findByCustomerIdOrderByStartDtDesc(customerId: Int): List<Loans?>?
}
