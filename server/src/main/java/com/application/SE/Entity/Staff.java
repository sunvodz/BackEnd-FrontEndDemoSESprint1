package com.application.SE.Entity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.util.*;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Staff")
public class Staff {
    @Id
    @SequenceGenerator(name="staff_seq",sequenceName="staff_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="staff_seq")
    @Column(name="Staff_ID",unique = true, nullable = false)
    private @NonNull Long staffId;
    private @NonNull String staffIds;
    public           String staffName;
    private          String staffPhone;
    private          int    staffSalary;
    private          String staffStatus;
    private          String staffJobtype;
    private          String staffGender;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Position.class)
    @JoinColumn(name = "positionId", insertable = true)
    private Position position;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Experience.class)
    @JoinColumn(name = "experienceId", insertable = true)
    private Experience experience;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Education.class)
    @JoinColumn(name = "educationId", insertable = true)
    private Education education;

}