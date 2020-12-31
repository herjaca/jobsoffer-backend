package com.donestreet.interview.jobsoffer.controller

import com.donestreet.interview.jobsoffer.model.Search
import com.donestreet.interview.jobsoffer.service.JobsOfferService
import khttp.responses.Response
import org.json.JSONArray
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:4200"])
@RestController
@RequestMapping("/jobsoffer")
@Configuration
class JobOfferController {

    @Autowired
    lateinit var jobsOfferService: JobsOfferService

    @GetMapping(produces= [MediaType.APPLICATION_JSON_VALUE])
    fun fetchGitHubJobs(@RequestParam location:String, @RequestParam description:String): ResponseEntity<Any> {
        val jobs:Response = jobsOfferService.fetchGitHubJobs(description,location)
        return if (jobs != null) {
            ResponseEntity(jobs.text,HttpStatus.OK)
        }else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping()
    fun saveSearch(@RequestBody search: Search):ResponseEntity<Unit>{
        jobsOfferService.save(search)
        return ResponseEntity(Unit,HttpStatus.CREATED)
    }

}

