package com.team22.backend.Controller;
import com.team22.backend.Entity.*;
import com.team22.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

class StaffController {
    @Autowired
    private final StaffRepository staffRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private ExperienceRepository experienceRepository;


    @Autowired
    StaffController(StaffRepository staffRepository,
                    PositionRepository positionRepository,
                    EducationRepository educationRepository,
                    ExperienceRepository experienceRepository
    ){
        this.staffRepository = staffRepository;
        this.positionRepository = positionRepository;
        this.educationRepository = educationRepository;
        this.experienceRepository = experienceRepository;
    }
    @GetMapping("/staff")
    public Collection<Staff> staff() {
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/education")
    public Collection<Education> education() {
        return educationRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/position")
    public Collection<Position> position() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/experience")
    public Collection<Experience> experience() {
        return experienceRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/staffs/{staffName}/{staffGender}/{educationId}/{staffPhone}/{staffJobtype}/{staffSalary}/{positionId}/{staffStatus}/{experienceId}")
    public Staff newStaff(
            @PathVariable String staffName,
            @PathVariable String staffGender,
            @PathVariable Long educationId,
            @PathVariable Long experienceId,
            @PathVariable String staffPhone,
            @PathVariable String staffJobtype,
            @PathVariable int staffSalary,
            @PathVariable Long positionId,
            @PathVariable String staffStatus
    ) {
        Long i;
        Staff newStaff = new Staff();
        for( i=1L; i<9999L;i++) {
            if(staffRepository.findByStaffId(i) == null) {
                newStaff.setStaffIds("St"+i);
                break;
            }
        }

        Education education1 = educationRepository.findByEducationId(educationId);
        Position position1 = positionRepository.findByPositionId(positionId);
        Experience experience1 = experienceRepository.findByExperienceId(experienceId);

        newStaff.setStaffName(staffName);
        newStaff.setEducation(education1);
        newStaff.setExperience(experience1);
        newStaff.setStaffPhone(staffPhone);
        newStaff.setStaffJobtype(staffJobtype);
        newStaff.setStaffSalary(staffSalary);
        newStaff.setPosition(position1);
        newStaff.setStaffStatus(staffStatus);
        return staffRepository.save(newStaff);
    }


    @PutMapping("/staffupdate/{staffId}/{staffIds}/{staffName}/{staffPhone}/{staffSalary}/{staffStatus}/{positionId}/{educationId}/{staffGender}/{staffJobtype}/{experienceId}")
    public Staff newStaff2(
            Staff newStaff,
            @PathVariable Long staffId,
            @PathVariable String staffIds,
            @PathVariable String staffName,
            @PathVariable String staffPhone,
            @PathVariable int staffSalary,
            @PathVariable String staffStatus,
            @PathVariable Long educationId,
            @PathVariable Long experienceId,
            @PathVariable Long positionId,
            @PathVariable String staffJobtype,
            @PathVariable String staffGender) {

        Position position1 = positionRepository.findByPositionId(positionId);
        Education education1 = educationRepository.findByEducationId(educationId);
        Experience experience1 = experienceRepository.findByExperienceId(experienceId);
        return staffRepository.findById(staffId)
                .map(staff -> {
                            staff.setPosition(position1);
                            staff.setStaffGender(staffGender);
                            staff.setStaffJobtype(staffJobtype);
                            staff.setEducation(education1);
                            staff.setExperience(experience1);
                            staff.setStaffName(staffName);
                            staff.setStaffIds(staffIds);
                            staff.setStaffSalary(staffSalary);
                            staff.setStaffStatus(staffStatus);
                            staff.setStaffPhone(staffPhone);
                            return staffRepository.save(staff);
                        }
                ).orElseGet(() -> {
                    return staffRepository.save(newStaff);
                });
    }
}