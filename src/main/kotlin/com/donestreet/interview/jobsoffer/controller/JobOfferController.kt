package com.donestreet.interview.jobsoffer.controller

import com.donestreet.interview.jobsoffer.model.Search
import com.donestreet.interview.jobsoffer.repository.SearchRepository
import com.donestreet.interview.jobsoffer.service.JobsOfferService
import khttp.responses.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/jobsoffer")
@Configuration
class JobOfferController {

    @Autowired
    lateinit var searchRepository: SearchRepository
    @Autowired
    lateinit var jobsOfferService: JobsOfferService

    @PostMapping
    fun search(search: Search){
        try {
            jobsOfferService.fetchGitHubJobs(search.description, search.location)
        }catch (error: Error){
            println(error.message)
        }
        searchRepository.save(search)
    }
}

