package com.team22.backend.Entity;
import lombok.*;

import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name="Description") //ชื่อตาราง
public class Description {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="description_seq",sequenceName="description_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="description_seq")
    @Column(name="Description_ID",unique = true, nullable = false)

    private @NonNull
    Long DescriptionIds;
    private
    String dataDescription;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Detail.class)
    @JoinColumn(name = "Detail_ID", insertable = true)
    private  Detail detail;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "Product_ID", insertable = true)
    private  Product product;
}