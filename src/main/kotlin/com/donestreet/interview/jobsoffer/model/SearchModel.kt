package com.donestreet.interview.jobsoffer.model

import javax.persistence.*

@Entity
@Table(name="searches")
data class Search(
        //Todo("Review data types");
        val time: String,
        val description: String,
        val location: String,
        val userIpAddress: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1
){
        private constructor(): this("","","","")
}