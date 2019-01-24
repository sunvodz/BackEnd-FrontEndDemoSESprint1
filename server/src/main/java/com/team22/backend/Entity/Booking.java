package com.team22.backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Booking")
public class Booking {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="booking_seq",sequenceName="booking_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="booking_seq")
    @Column(name="BookingID",unique = true, nullable = false)
    private @NonNull Long bookingId;
    private  LocalDate bookingDate;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "stID", insertable = true)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "cusId", insertable = true)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Style.class)
    @JoinColumn(name = "styleID", insertable = true)
    private Style style;


}

