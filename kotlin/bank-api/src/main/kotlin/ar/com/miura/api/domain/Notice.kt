package ar.com.miura.api.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "notice_details")
class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notice_id")
    private val noticeId = 0

    @Column(name = "notice_summary")
    private val noticeSummary: String? = null

    @Column(name = "notice_details")
    private val noticeDetails: String? = null

    @Column(name = "notic_beg_dt")
    private val noticBegDt: LocalDateTime = LocalDateTime.now()

    @Column(name = "notic_end_dt")
    private val noticEndDt: LocalDateTime = LocalDateTime.now()

    @Column(name = "create_dt")
    private val createDt: LocalDateTime = LocalDateTime.now()

    @Column(name = "update_dt")
    private val updateDt: LocalDateTime = LocalDateTime.now()

}