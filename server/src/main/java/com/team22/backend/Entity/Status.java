package com.team22.backend.Entity;
import lombok.*;

import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name="Status") //ชื่อตาราง
public class Status {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="status_seq",sequenceName="status_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="status_seq")
    @Column(name="State_ID",unique = true, nullable = false)

    private @NonNull    Long stateId;
    private @NonNull    String statusProduct;

    public Status(String state){
        this.statusProduct = state;
    }

    public void setStateId(Long id){
        this.stateId = id;
    }
    public Long getStateId(){
        return this.stateId;
    }
    public void setStatusProduct(String status){
        this.statusProduct = status;
    }
    public String getStatusProduct(){
        return this.statusProduct;
    }
}