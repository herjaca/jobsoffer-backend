package com.donestreet.interview.jobsoffer.service

import com.donestreet.interview.jobsoffer.model.Search
import com.donestreet.interview.jobsoffer.repository.SearchRepository
import khttp.responses.Response
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

interface JobsOfferService {
    fun fetchGitHubJobs(description: String, location: String): Response
    fun save(search: Search)
    fun fetchgitHubJobsAndSaveSearch(search: Search):Response
}

@Service
class JobsOfferServiceImpl : JobsOfferService {

    @Value("\${github.api.jobs.url}")
    lateinit var apiJobUrl:String

    @Autowired
    lateinit var searchRepository: SearchRepository

    override fun fetchGitHubJobs(description:String, location: String ): Response {
        val params = mapOf("description" to description, "location" to location)
        val response:Response = khttp.get(apiJobUrl,params=params)
        return response
    }

    override fun save(search:Search){
        searchRepository.save(search)
    }

    override fun fetchgitHubJobsAndSaveSearch(search:Search):Response{
        save(search)
        return fetchGitHubJobs(search.description, search.location)
    }
}