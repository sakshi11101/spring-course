package com.spring_learning.spring_boot_rest;

import com.spring_learning.spring_boot_rest.model.JobPost;
import com.spring_learning.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@Controller - by default looks for view jsps to be returned in all the methods defined here
so if want to return a response body, then specify @RestController at class level or
@ResponseBody at method level.
*/
@RestController
@CrossOrigin(origins = "http://localhost:3000") /* This line alone is connecting backend (spring boot) and
frontend (react) together as they are on different ports, 3000- default port on which react application runs
*/
public class JobRestController {

    @Autowired
    private JobService jobService;

    @RequestMapping(path = "jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobPosts() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId) {  //PathVariable is to tell the spring that hey check for variables inside URL mentioned.
        return jobService.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobPost;
    }

    @PutMapping("jobPost")
    public void updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        jobService.deleteJob(postId);
        return "Job deleted with postId: " + postId;
    }
}

/* 1. Jackson library is what java by default uses to convert java objects into JSON, it will not by
default convert to XML or any other format, instead then have to use Jackson-XML library from maven
In postman, under headers, the key is "accept" and value is "application/json" or "application/xml"
or whatever content you want. */

/* 2. How to specify that data to be sent to client will only be json format and not any other format, so in
 request mapping where url path is specify, add produces key as well with "application/json" or "application/xml"
 data to sent and vice versa to specify what type of content to accept, use consumes and on client side from
  postman under headers, the key is content. */


