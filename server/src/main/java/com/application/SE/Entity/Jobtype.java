package com.application.SE.Entity;
import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Jobtype")

public class Jobtype {
    @Id
    @SequenceGenerator(name = "jobtype_seq", sequenceName = "jobtype_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobtype_seq")
    @Column(name = "jobtypeId", unique = true, nullable = false)

    private @NonNull    Long jobtypeId;
    private @NonNull    String jobtypeIds;
    private             String jobtypeName;

}