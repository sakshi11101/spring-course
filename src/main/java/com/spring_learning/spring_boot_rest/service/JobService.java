package com.spring_learning.spring_boot_rest.service;

import com.spring_learning.spring_boot_rest.model.JobPost;
import com.spring_learning.spring_boot_rest.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobrepo;

    public void addJob(JobPost jobPost) {
        jobrepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobrepo.findAll();
    }

    public JobPost getJob(final int postId) {
        Optional<JobPost> jobPost = jobrepo.findById(postId);
        if(jobPost.isPresent()) {
            return jobPost.get();
        }
        return null;
    }

    public void updateJob(final JobPost jobPost) {
        jobrepo.save(jobPost);
    }

    public void deleteJob(final int postId) {
        jobrepo.deleteById(postId);
    }

    public void load() {
        // ArrayList to store JobPost objects
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));

        jobrepo.saveAll(jobs);
    }

    //This method calls the repository and search in database based on given keyword either present in postProfile or postDescription.
    public List<JobPost> search(String postProfile, String postDescription) {
        return jobrepo.findByPostProfileContainingOrPostDescriptionContaining(postProfile, postDescription);
    }
}
