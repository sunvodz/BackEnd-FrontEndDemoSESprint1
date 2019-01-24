package com.application.SE.controller;
import com.application.SE.Entity.*;
import com.application.SE.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LeaseController {
    @Autowired
    private final LeaseRepository leaseRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private ProductRepository productRepository;


    public LeaseController(LeaseRepository leaseRepository, CustomerRepository customerRepository, StaffRepository staffRepository, ProductRepository productRepository) {
        this.leaseRepository = leaseRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
    }
    @GetMapping("/lease")
    public Collection<Lease> lease() {
        return leaseRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/renting/{productID}/{productName}/{productPrice}/{customerID}/{staffIDs}/{ReserveDate}/{ReturnDate}")
    public Lease newRenting(@PathVariable String productID,@PathVariable String productName,@PathVariable String productPrice,@PathVariable String customerID, @PathVariable String staffIDs
       , @PathVariable String ReserveDate, @PathVariable String ReturnDate){

         String sDate1 = ReserveDate;
         String sDate2 = ReturnDate;
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
         LocalDate date = LocalDate.parse(sDate1,formatter);
         LocalDate date1 = LocalDate.parse(sDate2,formatter);

         Lease newLease = new Lease();
         newLease.setStatus("not paid");
         Customer customer1= customerRepository.findByCustomerIDs(customerID);
         newLease.setCustomer(customer1);
         newLease.setDateStart(date);
         newLease.setDateEnd(date1);
         Staff staff = staffRepository.findByStaffIds(staffIDs);
         newLease.setStaff(staff);
         Product product = productRepository.findByProductIds(productID);
         newLease.setProduct(product);
         return leaseRepository.save(newLease);

}
}
