package com.team22.backend.Repository;
import com.team22.backend.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http;//localhost:4200")
@RepositoryRestResource

public interface EducationRepository extends JpaRepository<Education, Long> {
    Education findByEducationId(Long id);
    Education findByEducationName(String educationName);
//    Gender findByGenderIds(String genderIds);
}