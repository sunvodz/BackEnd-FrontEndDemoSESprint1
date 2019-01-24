package com.team22.backend.Repository;
import com.team22.backend.Entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public
interface  StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByStaffId(Long id);
    Staff findByStaffIds(String staffIds);
}
