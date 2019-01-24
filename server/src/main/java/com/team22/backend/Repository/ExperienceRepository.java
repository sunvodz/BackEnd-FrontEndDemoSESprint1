package com.team22.backend.Repository;
import com.team22.backend.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@CrossOrigin(origins = "http;//localhost:4200")
@RepositoryRestResource

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    Experience findByExperienceId(Long id);
    Experience findByExperienceName(String ExperienceName);
}