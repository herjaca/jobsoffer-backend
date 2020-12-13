package com.donestreet.interview.jobsoffer.service

import khttp.get
import khttp.responses.Response
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class JobsOfferService {

    @Value("\${github.api.jobs.url}")
    lateinit var apiJobUrl:String

    fun fetchGitHubJobs(description:String, location: String ):Response {

        if (description.isEmpty() && location.isEmpty()) {
            TODO("Lanzar excepcion http - faltan parametros")
        } else {
            println("Entro en el service")
            val params = mapOf("description" to description, "location" to location)
            println("params: $params")
            return get(apiJobUrl, params = params)
        }

    }
}