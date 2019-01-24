package com.team22.backend.Controller;
import com.team22.backend.Entity.*;
import com.team22.backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SellingController {
    @Autowired
    private SellingRepository sellingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private ProductRepository productRepository;

    public SellingController(SellingRepository sellingRepository,CustomerRepository customerRepository,StaffRepository staffRepository, ProductRepository productRepository) {
        this.sellingRepository = sellingRepository;
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.productRepository = productRepository;
    }
    @GetMapping("/selling")
    public Collection<Selling> selling() {
        return sellingRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/productSelling")
    public Collection<Product> product() {
        return productRepository.findAll().stream()
                .filter(this::isProduct)
                .collect(Collectors.toList());
    }
    private boolean isProduct(Product product){

        return product.getStatus().getStatusProduct().equals("Selling");
    }

    @RequestMapping("/staffSeller")
    public Collection<Staff> staff() {
        return staffRepository.findAll().stream()
                .filter(this::isStaff)
                .collect(Collectors.toList());
    }
    private boolean isStaff(Staff staff){
        return staff.getPosition().getPositionName().equals("Seller");
    }

    @PostMapping("/sell/{productID}/{productName}/{productPrice}/{customerID}/{staffIDs}/{sellingDate}")
        public Selling newSSel(@PathVariable String productID,@PathVariable String productName,@PathVariable Integer productPrice,@PathVariable String customerID,@PathVariable String staffIDs,@PathVariable String sellingDate){
            Selling newSelling = new Selling();
            Product product = productRepository.findByProductIds(productID);
            Customer customer = customerRepository.findByCustomerIDs(customerID);
            Staff staff = staffRepository.findByStaffIds(staffIDs);

        String sDate1 = sellingDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        LocalDate date = LocalDate.parse(sDate1,formatter);
        newSelling.setStatus("not paid");
        newSelling.setProduct(product);
        newSelling.setCustomer(customer);
        newSelling.setStaff(staff);
        newSelling.setSellingDate(date);
        System.out.println(date);
        return sellingRepository.save(newSelling);
        }


}
