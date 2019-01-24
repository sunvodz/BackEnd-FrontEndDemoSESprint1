package com.application.SE.Entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Payer")

public class Payer {

    @Id
    @SequenceGenerator(name = "payer_seq", sequenceName = "payer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payer_seq")
    @Column(name = "payerId", unique = true, nullable = false)

    private @NonNull    Long payerId;
    private @NonNull    String payerIds;
    private             String payerName;


}
