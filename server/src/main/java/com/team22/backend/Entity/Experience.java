package com.team22.backend.Entity;
    import javax.persistence.*;
    import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Experience")

public class Experience{
    @Id
    @SequenceGenerator(name = "experience_seq", sequenceName = "experience_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq")
    @Column(name = "experienceId", unique = true, nullable = false)

    private @NonNull    Long experienceId;
    private @NonNull    String experienceIds;
    private             String experienceName;

}