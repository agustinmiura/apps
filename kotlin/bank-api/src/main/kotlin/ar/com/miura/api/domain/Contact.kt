package ar.com.miura.api.domain

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "contact_messages")
class Contact {

    @Id
    @Column(name = "contact_id")
    internal var contactId: String? = null

    @Column(name = "contact_name")
    private var contactName: String? = null

    @Column(name = "contact_email")
    private var contactEmail: String? = null

    private var subject: String? = null

    private var message: String? = null

    @Column(name = "create_dt")
    internal var createDt: LocalDateTime = LocalDateTime.now()
}