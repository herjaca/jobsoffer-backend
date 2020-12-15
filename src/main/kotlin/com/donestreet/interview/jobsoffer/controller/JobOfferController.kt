package com.donestreet.interview.jobsoffer.controller

import com.donestreet.interview.jobsoffer.model.Search
import com.donestreet.interview.jobsoffer.service.JobsOfferService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:4200"])
@RestController
@RequestMapping("/jobsoffer")
@Configuration
class JobOfferController {

    @Autowired
    lateinit var jobsOfferService: JobsOfferService

    @PostMapping("/search")
    fun search(@RequestBody search: Search):ResponseEntity<Any>{
        jobsOfferService.save(search)

        var response = jobsOfferService.fetchGitHubJobs(search.description,search.location)
        return ResponseEntity(response,HttpStatus.OK)
    }
}

