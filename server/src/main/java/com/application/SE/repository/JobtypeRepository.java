package com.application.SE.repository;
import com.application.SE.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http;//localhost:4200")
@RepositoryRestResource

public interface JobtypeRepository extends JpaRepository<Jobtype, Long> {
    Jobtype findByJobtypeId(Long id);
    Jobtype findByJobtypeName(String jobtype);
//    Gender findByGenderIds(String genderIds);
}