package com.team22.backend.Entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Selling")
public class Selling {
    @Id
    @SequenceGenerator(name="selling_seq",sequenceName="selling_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="selling_seq")
    @Column(name="Selling_ID",unique = true, nullable = false)
    private @NonNull Long sellingId;
    private  LocalDate sellingDate;
    private   @NonNull String status;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "customerId", insertable = true)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "staffId", insertable = true)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "productId", insertable = true)
    private Product product;





}

