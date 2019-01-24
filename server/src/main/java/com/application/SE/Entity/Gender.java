package com.application.SE.Entity;
        import javax.persistence.*;

        import lombok.*;


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Gender")

public class Gender {
    @Id
    @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")
    @Column(name = "genderId", unique = true, nullable = false)

    private @NonNull    Long genderId;
    private @NonNull    String genderIds;
    private             String genderName;

}