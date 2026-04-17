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

    @RequestMapping("jobPosts")
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
