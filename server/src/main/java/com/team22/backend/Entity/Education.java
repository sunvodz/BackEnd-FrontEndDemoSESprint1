package com.team22.backend.Entity;
import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Education")

public class Education {
    @Id
    @SequenceGenerator(name = "education_seq", sequenceName = "education_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_seq")
    @Column(name = "educationId", unique = true, nullable = false)

    private @NonNull    Long educationId;
    private @NonNull    String educationIds;
    private             String educationName;

}