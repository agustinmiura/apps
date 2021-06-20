package ar.com.miura.api.domain

import javax.persistence.Column
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table

@Entity
@Table(name="custom_users")
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: String,

    var email:String,

    var pwd:String,

    var role_column:String
) {
    constructor() : this("","","","")
}

