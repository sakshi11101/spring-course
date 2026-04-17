package com.spring_learning.spring_boot_rest.repo;

import com.spring_learning.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository {

    // ArrayList to store JobPost objects
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(

            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                    List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                    List.of("HTML", "CSS", "JavaScript", "React")),

            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                    List.of("Python", "Machine Learning", "Data Analysis")),

            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                    List.of("Networking", "Cisco", "Routing", "Switching")),

            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                    List.of("iOS Development", "Android Development", "Mobile App"))
    ));

    //method to add job to database or any other storage layer.
    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
        System.out.println(jobs);
    }

    //method to get list of data from database or other storage layer.
    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public JobPost getJob(int postId) {
        for(JobPost job : jobs) {
            if(job.getPostId() == postId) {
                return job;
            }
        }

        return null;
    }

    public void updateJob(final JobPost jobPost) {
        for(JobPost job : jobs) {
            if(job.getPostId() == jobPost.getPostId()) {
                job.setPostId(jobPost.getPostId());
                job.setPostDescription((jobPost.getPostDescription()));
                job.setPostProfile((jobPost.getPostProfile()));
                job.setRequiredExperience((jobPost.getRequiredExperience()));
                job.setPostTechStack((jobPost.getPostTechStack()));
            }
        }
    }

    public void deleteJob(final int postId) {
        jobs.removeIf(j -> j.getPostId() == postId);
    }
}
