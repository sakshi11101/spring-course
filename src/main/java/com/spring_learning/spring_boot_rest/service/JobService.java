package com.spring_learning.spring_boot_rest.service;

import com.spring_learning.spring_boot_rest.model.JobPost;
import com.spring_learning.spring_boot_rest.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobrepo;

    public void addJob(JobPost jobPost) {
        jobrepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobrepo.getAllJobs();
    }

    public JobPost getJob(final int postId) {
        return jobrepo.getJob(postId);
    }

    public void updateJob(final JobPost jobPost) {
        jobrepo.updateJob(jobPost);
    }

    public void deleteJob(final int postId) {
        jobrepo.deleteJob(postId);
    }
}
