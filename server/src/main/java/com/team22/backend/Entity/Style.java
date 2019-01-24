package com.team22.backend.Entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Style")
public class Style {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="style_seq",sequenceName="style_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="style_seq")
    @Column(name="StyleId",unique = true, nullable = false)
    private @NonNull Long styleID;
    private  String styleIDs;
    private  String styleName;
    private  int stylePrice;

}
