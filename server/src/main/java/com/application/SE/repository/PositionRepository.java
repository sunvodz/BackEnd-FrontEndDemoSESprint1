package com.application.SE.repository;
import com.application.SE.Entity.*;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http;//localhost:4200")
@RepositoryRestResource

public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findByPositionId(Long id);
    Position findByPositionName(String position);
//    Position findByPositionIds(String positionIds);
//    Position findByPosition(String positionName);
}