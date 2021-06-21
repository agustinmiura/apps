package ar.com.miura.api.controller

import ar.com.miura.api.domain.Notice
import ar.com.miura.api.repository.NoticeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NoticesController @Autowired constructor(private val noticeRepository: NoticeRepository){

    @GetMapping("/notices")
    fun getNotices(input:String):List<Notice>? {
        val notices = noticeRepository.findAllActiveNotices()
        if (notices!=null) {
            return notices
        } else {
            return null
        }
    }

}