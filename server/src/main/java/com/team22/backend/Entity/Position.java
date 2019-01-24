package com.team22.backend.Entity;
import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Position")

public class Position {
    @Id
    @SequenceGenerator(name = "position_seq", sequenceName = "position_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq")
    @Column(name = "positionId", unique = true, nullable = false)

    private @NonNull    Long positionId;
    private @NonNull    String positionIds;
    private             String positionName;

}