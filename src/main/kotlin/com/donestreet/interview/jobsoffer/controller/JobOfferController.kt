package com.donestreet.interview.jobsoffer.controller

import com.donestreet.interview.jobsoffer.model.Search
import com.donestreet.interview.jobsoffer.service.JobsOfferService
import khttp.responses.Response
import org.json.JSONArray
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

    @PostMapping()
    fun search(@RequestBody search: Search):Any{
        var response = jobsOfferService.fetchgitHubJobsAndSaveSearch(search)
        println("Resposne: ${response.jsonArray}")
        //return response.jsonArray
        return response.text
    }
}

