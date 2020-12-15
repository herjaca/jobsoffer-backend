package com.donestreet.interview.jobsoffer.service

import com.donestreet.interview.jobsoffer.model.Search
import com.donestreet.interview.jobsoffer.repository.SearchRepository
import khttp.get
import khttp.responses.Response
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

interface JobsOfferService {
    fun fetchGitHubJobs(description: String, location: String): String
    fun save(search: Search)
}

@Service
class JobsOfferServiceImpl : JobsOfferService {

    @Value("\${github.api.jobs.url}")
    lateinit var apiJobUrl:String

    @Autowired
    lateinit var searchRepository: SearchRepository

    override fun fetchGitHubJobs(description:String, location: String ): String {
        println("-- Service --")
        val params = mapOf("description" to description, "location" to location)
        println("params: $params")
        val response =  get(apiJobUrl, params = params)

        println(response.text)
        return response.text
    }

    override fun save(search:Search){
        searchRepository.save(search)
    }
}