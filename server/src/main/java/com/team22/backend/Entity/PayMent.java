package com.team22.backend.Entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="PayMent")
public class PayMent {
    @Id
    @SequenceGenerator(name="payMent_seq",sequenceName="payMent_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="payMent_seq")
    @Column(name="PayMent_ID",unique = true, nullable = false)
    private @NonNull Long pmId;
    private @NonNull Date datePay;
    private String typePay;
    private String statusPay;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookingId")
    private Booking booking;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leaseId")
    private Lease lease;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sellingId")
     private Selling selling;

     
}