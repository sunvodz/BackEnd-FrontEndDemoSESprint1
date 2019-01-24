package com.team22.backend.Controller;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.team22.backend.Entity.*;
import com.team22.backend.Repository.*;
import java.util.*;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PayMentController {
        @Autowired
        private PayMentRepository paymentRepository;
        @Autowired
        private StaffRepository staffRepository;
        @Autowired
        private CustomerRepository customerRepository;
        @Autowired
        private BookingRepository bookingRepository;
        @Autowired
        private SellingRepository sellingRepository;
        @Autowired
        private LeaseRepository leaseRepository;
        public PayMentController(PayMentRepository paymentRepository,
                                 StaffRepository staffRepository,
                                 CustomerRepository customerRepository,
                                 BookingRepository bookingRepository,
                                 SellingRepository sellingRepository,
                                 LeaseRepository leaseRepository,
                                 ProductRepository productRepository) {
            this.paymentRepository = paymentRepository;
            this.staffRepository = staffRepository;
            this.customerRepository = customerRepository;
            this.bookingRepository = bookingRepository;
            this.sellingRepository = sellingRepository;
            this.leaseRepository = leaseRepository;
        }
        
        @GetMapping("/payment")
        public Collection<PayMent> payment() {
            return paymentRepository.findAll().stream()
                    .filter(this::isPayMent)
                    .collect(Collectors.toList());
        }
        private boolean isPayMent(PayMent payMent){
            return payMent.getStatusPay().equals("paid");
        }


        @GetMapping("/pselling")
        public Collection<Selling> selling() {
            return sellingRepository.findAll().stream()
            .filter(this::isSelling)
            .collect(Collectors.toList());
        }
        private boolean isSelling(Selling selling){
        return selling.getStatus().equals("not paid");
        }
        @GetMapping("/pselling/{id}")
        public Collection<Selling> selling(@PathVariable String id) {
            return sellingRepository.findAll().stream()
            .filter((s) -> "not paid".equals(s.getStatus()) && id.equals(s.getCustomer().getCustomerIDs()))
            .collect(Collectors.toList());
        }

        @GetMapping("/please")
        public Collection<Lease> lease() {
            return leaseRepository.findAll().stream()
            .filter(this::isLease)
            .collect(Collectors.toList());
        }
        private boolean isLease(Lease lease){
            return lease.getStatus().equals("not paid");
        }   
        @GetMapping("/please/{id}")
        public Collection<Lease> lease(@PathVariable String id) {
            return leaseRepository.findAll().stream()
            .filter((s) -> "not paid".equals(s.getStatus()) && id.equals(s.getCustomer().getCustomerIDs()))
            .collect(Collectors.toList());
        }
       
        @GetMapping("/pbooking")
        public Collection<Booking> booking() {
            return bookingRepository.findAll().stream()
            .filter(this::isBooking)
            .collect(Collectors.toList());
        }
        private boolean isBooking(Booking booking){
            return booking.getStatus().equals("not paid");
        }
        @GetMapping("/pbooking/{id}")
        public Collection<Booking> booking(@PathVariable String id) {
            return bookingRepository.findAll().stream()
            .filter((s) -> "not paid".equals(s.getStatus()) && id.equals(s.getCustomer().getCustomerIDs()))
            .collect(Collectors.toList());
        }
        
        @GetMapping("/pstaff")
        public Collection<Staff> staff() {
            return staffRepository.findAll().stream()
                    .filter(this::isStaff)
                    .collect(Collectors.toList());
        }
            private boolean isStaff(Staff staff){
                return staff.getStaffName().equals("Admin");
        }
        @GetMapping("/pcustomer")
        public Collection<Customer> customer() {
            return customerRepository.findAll().stream()
            .collect(Collectors.toList());
        }

        @PostMapping("/payment/{typepay}/{statuspay}/{customer}/{selling}/{style}/{lease}")
        public PayMent newPayMent(@PathVariable String typepay,@PathVariable String statuspay,
                            @PathVariable String customer,@PathVariable Long selling,
                            @PathVariable Long style,@PathVariable Long lease){
        PayMent newPayMent = new PayMent();
        newPayMent.setStatusPay(statuspay);
        newPayMent.setTypePay(typepay);
        
        Date datePay = new Date();
        newPayMent.setDatePay(datePay);
       
        Customer customerid = customerRepository.findByCustomerIDs(customer);
        newPayMent.setCustomer(customerid);
        
        
        Selling sellingid = sellingRepository.findBySellingId(selling);
        newPayMent.setSelling(sellingid);
       
        Booking styleid = bookingRepository.findBybookingId(style);
        newPayMent.setBooking(styleid);
       
        Lease leaseid = leaseRepository.findByLeaseId(lease);
        newPayMent.setLease(leaseid);
      
        return paymentRepository.save(newPayMent); 
    }

    @PutMapping("/booking/{id}/{status}")
    Booking replaceBooking(Booking newBooking, @PathVariable String status, @PathVariable Long id){

        return bookingRepository.findById(id)
                    .map(booking ->{
                    booking.setStatus(status);
                    return bookingRepository.save(booking);
                }
                ).orElseGet(() ->{
                    newBooking.setBookingId(id);
                    return bookingRepository.save(newBooking);
        });
}
    @PutMapping("/selling/{id}/{status}")
    Selling replaceSelling(Selling newSelling, @PathVariable String status, @PathVariable Long id){

    return sellingRepository.findById(id)
                .map(selling ->{
                selling.setStatus(status);
                return sellingRepository.save(selling);
            }
            ).orElseGet(() ->{
                newSelling.setSellingId(id);
                return sellingRepository.save(newSelling);
    });
}
    @PutMapping("/lease/{id}/{status}")
    Lease replaceLease(Lease newLease, @PathVariable String status, @PathVariable Long id){

    return leaseRepository.findById(id)
                .map(lease ->{
                lease.setStatus(status);
                return leaseRepository.save(lease);
            }
            ).orElseGet(() ->{
                newLease.setLeaseId(id);
                return leaseRepository.save(newLease);
    });
}
}