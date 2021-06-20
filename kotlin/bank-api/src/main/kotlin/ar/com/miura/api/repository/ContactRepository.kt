package ar.com.miura.api.repository
import ar.com.miura.api.domain.Contact
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface ContactRepository : CrudRepository<Contact?, Long?>
