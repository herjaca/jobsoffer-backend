package com.donestreet.interview.jobsoffer.repository

import com.donestreet.interview.jobsoffer.model.Search
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SearchRepository: CrudRepository<Search,Long>{
}