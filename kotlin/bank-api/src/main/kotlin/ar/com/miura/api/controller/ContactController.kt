package ar.com.miura.api.controller

import ar.com.miura.api.domain.Contact
import ar.com.miura.api.repository.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
class ContactController {
    @Autowired
    private val contactRepository: ContactRepository? = null

    @PostMapping("/contact")
    fun saveContactInquiryDetails(@RequestBody contact: Contact): Contact? {
        contact.contactId = (getServiceReqNumber())
        contact.createDt =
        return contactRepository!!.save(contact)
    }

    fun getServiceReqNumber(): String? {
        val random = Random()
        val ranNum: Int = random.nextInt(999999999 - 9999) + 9999
        return "SR$ranNum"
    }
}
