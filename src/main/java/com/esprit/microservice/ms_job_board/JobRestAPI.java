package com.esprit.microservice.ms_job_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobRestAPI {

    private String hello="Hello, i'm the Job MS";

    @RequestMapping("/helloJ")
    public String sayHello(){
        return hello;
    }

    @Autowired
    private JobService jobService;

    @RequestMapping
    public ResponseEntity<List<Job>> getAll() {

        return new ResponseEntity<>(jobService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job>addJob( @RequestBody Job b)
    {
      return  new ResponseEntity<Job> (jobService.addJob(b),HttpStatus.CREATED);
    }

    @RequestMapping("{id}")
    public Job getJobById(@PathVariable int id){
        return jobService.getJobById(id);
    }
}
