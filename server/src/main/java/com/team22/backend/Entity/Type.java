package com.team22.backend.Entity;
import lombok.*;

import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name="Type") //ชื่อตาราง
public class Type {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="type_seq")
    @Column(name="Types_ID",unique = true, nullable = false)
    private @NonNull Long typeIds;
    private @NonNull String typeName;
    public Type (String ty){
        this. typeName = ty;
    }
}