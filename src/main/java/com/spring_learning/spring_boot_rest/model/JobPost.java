package com.spring_learning.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {
    @Id
    @NonNull
    private int postId;
    @NonNull
    private String postProfile;
    @NonNull
    private String postDescription;
    @NonNull
    private int requiredExperience;
    @NonNull
    private List<String> postTechStack;
}
