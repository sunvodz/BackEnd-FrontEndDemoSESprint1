package com.application.SE;
import com.application.SE.repository.*;
import com.application.SE.Entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class Data {

//    Date date = new Date();
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Data.class, args);
    }


    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    ApplicationRunner init(PositionRepository positionRepository,
                           StaffRepository staffRepository,
                           SellingRepository sellingRepository,
                           EducationRepository educationRepository,
                           DetailRepository detailRepository,
                           ProductRepository productRepository,
                           StatusRepository statusRepository,
                           BookingRepository bookingRepository,
                           CustomerRepository customerRepository,
                           TypeRepository typeRepository,
                           StyleRepository styleRepository,
                           LeaseRepository leaseRepository,
                           PayMentRepository  payMentRepository,
                           ExperienceRepository experienceRepository
                           ) {
        return args -> {

            Stream.of("Renting", "Selling", "Stocking").forEach(status -> {
                Status state = new Status(status);
                statusRepository.save(state);
            });
            Status sta1 = statusRepository.findByStateId(1L);
            Status sta2 = statusRepository.findByStateId(2L);
            Status sta3 = statusRepository.findByStateId(3L);
            Stream.of("Cloth", "Shoes", "Cosmetic", "Hair", "Accessories", "OtherType").forEach(tName -> {
                Type typeprodName = new Type(tName);
                typeRepository.save(typeprodName);
            });
            Stream.of("Bust", "Waist", "Hip", "Length", "Size", "OtherDetail").forEach(dName -> {
                Detail dprodName = new Detail(dName);
                detailRepository.save(dprodName);
            });

            Stream.of("M.3","M.6","Polytechnical College","Technical College","Bachelor Degrees","Master Degrees").forEach(EduName -> {
				Education educationdb = new Education();
				educationdb.setEducationName(EduName);
				educationRepository.save(educationdb);

				if (EduName == "M.3") {
					educationdb.setEducationIds("E"+educationdb.getEducationId());
					educationdb.setEducationName(EduName);
					educationRepository.save(educationdb);
				}
				else if(EduName == "M.6") {
					educationdb.setEducationIds("E"+educationdb.getEducationId());
					educationdb.setEducationName(EduName);
					educationRepository.save(educationdb);
				}
				else if (EduName == "Polytechnical College") {
					educationdb.setEducationIds("E"+educationdb.getEducationId());
					educationdb.setEducationName(EduName);
					educationRepository.save(educationdb);
				}
				else if(EduName == "Technical College") {
					educationdb.setEducationIds("E"+educationdb.getEducationId());
					educationdb.setEducationName(EduName);
					educationRepository.save(educationdb);
				}
				else if (EduName == "Bachelor Degrees") {
					educationdb.setEducationIds("E"+educationdb.getEducationId());
					educationdb.setEducationName(EduName);
					educationRepository.save(educationdb);
				}
				else if(EduName == "Master Degrees") {
					educationdb.setEducationIds("E"+educationdb.getEducationId());
					educationdb.setEducationName(EduName);
					educationRepository.save(educationdb);
				}
			});

			Education ed1 = educationRepository.findByEducationId(1L);
			Education ed2 = educationRepository.findByEducationId(2L);
			Education ed3 = educationRepository.findByEducationId(3L);
			Education ed4 = educationRepository.findByEducationId(4L);
			Education ed5 = educationRepository.findByEducationId(5L);
			Education ed6 = educationRepository.findByEducationId(6L);

            Stream.of("0 Year","1-3 Year","4-6 Year","7-9 Year","10 to Up").forEach(ExName -> {
				Experience experiencedb = new Experience();
				experiencedb.setExperienceName(ExName);
				experienceRepository.save(experiencedb);

				if (ExName == "0 Year") {
					experiencedb.setExperienceIds("Ex"+experiencedb.getExperienceId());
					experiencedb.setExperienceName(ExName);
					experienceRepository.save(experiencedb);
				}
				else if(ExName == "1-3 Year") {
					experiencedb.setExperienceIds("Ex"+experiencedb.getExperienceId());
					experiencedb.setExperienceName(ExName);
					experienceRepository.save(experiencedb);
				}if (ExName == "4-6 Year") {
					experiencedb.setExperienceIds("Ex"+experiencedb.getExperienceId());
					experiencedb.setExperienceName(ExName);
					experienceRepository.save(experiencedb);
				}
				else if(ExName == "7-9 Year") {
					experiencedb.setExperienceIds("Ex"+experiencedb.getExperienceId());
					experiencedb.setExperienceName(ExName);
					experienceRepository.save(experiencedb);
				}else if (ExName == "10 to Up") {
					experiencedb.setExperienceIds("Ex"+experiencedb.getExperienceId());
					experiencedb.setExperienceName(ExName);
					experienceRepository.save(experiencedb);
				}
			});
			Experience ex1 = experienceRepository.findByExperienceId(1L);
			Experience ex2 = experienceRepository.findByExperienceId(2L);
			Experience ex3 = experienceRepository.findByExperienceId(3L);
			Experience ex4 = experienceRepository.findByExperienceId(4L);
			Experience ex5 = experienceRepository.findByExperienceId(5L);

            Stream.of("Sunvo", "Ploy", "Ao" ,"Wahn","Opal","Meen").forEach(cusName -> {

                Customer customerdb = new Customer();
                customerdb.setCustomerName(cusName);
                customerRepository.save(customerdb);

                if (cusName == "Sunvo") {
                    Customer cusid = customerRepository.findByCusId(1L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setAddressCustomer("Korat");
                    customerRepository.save(customerdb);

                }
                else if(cusName == "Ploy"){
                    Customer cusid = customerRepository.findByCusId(2L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setAddressCustomer("Suranaree");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Ao"){
                    Customer cusid = customerRepository.findByCusId(3L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setAddressCustomer("Sungneon");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Wahn"){
                    Customer cusid = customerRepository.findByCusId(4L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setAddressCustomer("Krathok");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Opal"){
                    Customer cusid = customerRepository.findByCusId(5L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setAddressCustomer("Khonkan");
                    customerRepository.save(customerdb);
                }
                else if(cusName == "Meen"){
                    Customer cusid = customerRepository.findByCusId(6L);
                    customerdb.setCustomerIDs("C"+cusid.getCusId());
                    customerdb.setAddressCustomer("Korat");
                    customerRepository.save(customerdb);
                }
            });
            Customer c1 = customerRepository.findByCusId(1L);
            Customer c2 = customerRepository.findByCusId(2L);
            Customer c3 = customerRepository.findByCusId(3L);
            Customer c4 = customerRepository.findByCusId(4L);
            Customer c5 = customerRepository.findByCusId(5L);
            Customer c6 = customerRepository.findByCusId(6L);

            Type type1 = typeRepository.findByTypeIds(1L);
            Stream.of("Dress").forEach(proName ->{
                Product productName = new Product();
                productName.setProductName(proName);
                productRepository.save(productName);

                if(proName == "Dress") {
                    Product prodid = productRepository.findByProdId(1L);
                    productName.setProductIds("P" + prodid.getProdId());
                    productName.setProductPrice(1000);
                    productName.setProductQuantity(18);
                    productName.setStatus(sta1);
                    productName.setType(type1);
                    productRepository.save(productName);
                }

            });
            Product pt1 = productRepository.findByProdId(1L);

            Stream.of("korea style", "thai style", "laos style","wedding", "thai wedding", "chinese style").forEach(styName -> {
                Style styledb = new Style();
                styledb.setStyleName(styName);
                styleRepository.save(styledb);

                if (styName == "korea style") {
                    Style styleID = styleRepository.findBystyleID(1L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(3000);
                    styleRepository.save(styledb);
                }
                else if(styName == "thai style"){
                    Style styleID = styleRepository.findBystyleID(2L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(2000);
                    styleRepository.save(styledb);
                }
                else if(styName == "laos style"){
                    Style styleID = styleRepository.findBystyleID(3L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(1700);
                    styleRepository.save(styledb);
                }
                else if(styName == "wedding"){
                    Style styleID = styleRepository.findBystyleID(4L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(5000);
                    styleRepository.save(styledb);
                }
                else if(styName == "thai wedding"){
                    Style styleID = styleRepository.findBystyleID(5L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(4500);
                    styleRepository.save(styledb);
                }
                else if(styName == "chinese style"){
                    Style styleID = styleRepository.findBystyleID(6L);
                    styledb.setStyleIDs("Sy"+styleID.getStyleID());
                    styledb.setStylePrice(2500);
                    styleRepository.save(styledb);
                }
            });
            Style sy1 = styleRepository.findBystyleID(1L);
            Style sy2 = styleRepository.findBystyleID(2L);
            Style sy3 = styleRepository.findBystyleID(3L);
            Style sy4 = styleRepository.findBystyleID(4L);
            Style sy5 = styleRepository.findBystyleID(5L);
            Style sy6 = styleRepository.findBystyleID(6L);

            Stream.of("Stylist","Service","HairStylist", "MakeupArtist","Renter","Seller","Accountant").forEach(posName -> {
                Position positiondb = new Position();
                positiondb.setPositionName(posName);
                positionRepository.save(positiondb);

                if (posName == "Stylist") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }

                else if(posName == "Service") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }

                else if (posName == "HairStylist") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }

                else if(posName == "MakeupArtist") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }

                else if(posName == "Renter") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }

                else if(posName == "Seller") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }

                else if(posName == "Accountant") {
                    positiondb.setPositionIds("P"+positiondb.getPositionId());
                    positiondb.setPositionName(posName);
                    positionRepository.save(positiondb);
                }
            });

            Position po1 = positionRepository.findByPositionId(1L);
            Position po2 = positionRepository.findByPositionId(2L);
            Position po3 = positionRepository.findByPositionId(3L);
            Position po4 = positionRepository.findByPositionId(4L);
            Position po5 = positionRepository.findByPositionId(5L);
            Position po6 = positionRepository.findByPositionId(6L);
            Position po7 = positionRepository.findByPositionId(7L);


            Stream.of("Owner", "Ploy", "Sunvo" , "Au").forEach(staffName -> {
                Staff staffdb = new Staff();
                staffdb.setStaffName(staffName);
                staffRepository.save(staffdb);

                if (staffName == "Owner") {
                    staffdb.setStaffIds("St"+staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setEducation(ed1);
                    staffdb.setExperience(ex1);
                    staffdb.setStaffGender("Man");
                    staffdb.setStaffJobtype("Full Time");
                    staffdb.setStaffPhone("086-141-9833");
                    staffdb.setStaffSalary(50000);
                    staffdb.setPosition(po6);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                }
                else    if (staffName == "Ploy") {
                    staffdb.setStaffIds("St"+staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffGender("Woman");
                    staffdb.setStaffJobtype("Part Time");
                    staffdb.setEducation(ed2);
                    staffdb.setExperience(ex2);
                    staffdb.setStaffPhone("081-108-6599");
                    staffdb.setStaffSalary(29000);
                    staffdb.setPosition(po5);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                }
                else    if (staffName == "Sunvo") {
                    staffdb.setStaffIds("St"+staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffGender("Man");
                    staffdb.setStaffJobtype("Part Time");
                    staffdb.setEducation(ed3);
                    staffdb.setExperience(ex3);
                    staffdb.setStaffPhone("081-105-6559");
                    staffdb.setStaffSalary(20000);
                    staffdb.setPosition(po4);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                }
                else    if (staffName == "Au") {
                    staffdb.setStaffIds("St"+staffdb.getStaffId());
                    staffdb.setStaffName(staffName);
                    staffdb.setStaffGender("Man");
                    staffdb.setStaffJobtype("Part Time");
                    staffdb.setEducation(ed4);
                    staffdb.setExperience(ex4);
                    staffdb.setStaffPhone("081-103-6559");
                    staffdb.setStaffSalary(2500);
                    staffdb.setPosition(po3);
                    staffdb.setStaffStatus("Un Paid");
                    staffRepository.save(staffdb);
                }
            });
            Staff st1 = staffRepository.findByStaffId(1L);
            Staff st2 = staffRepository.findByStaffId(2L);

            Booking bookingdb = new Booking();
            String bDate1 = "20:04:1998";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate bdate = LocalDate.parse(bDate1, formatter);
            bookingRepository.save(bookingdb);

            bookingdb.setBookingDate(bdate);
            bookingdb.setCustomer(c3);
            bookingdb.setStatus("not paid");
            bookingdb.setStaff(st1);
            bookingdb.setStyle(sy1);
            bookingRepository.save(bookingdb);

            Lease leasedb = new Lease();
            String lDate1 = "20:04:1998";
            String lDate2 = "21:05:1998";
            DateTimeFormatter lformatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate ldate = LocalDate.parse(lDate1, lformatter);
            LocalDate ldate1 = LocalDate.parse(lDate2, lformatter);
            leasedb.setCustomer(c3);
            leasedb.setDateStart(ldate);
            leasedb.setDateEnd(ldate1);
            leasedb.setStatus("paid");
            leasedb.setStaff(st1);
            leasedb.setProduct(pt1);
            leaseRepository.save(leasedb);

            Lease leasedb2 = new Lease();
            String l2Date1 = "11:11:1998";
            String l2Date2 = "12:12:1998";
            DateTimeFormatter l2formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate l2date = LocalDate.parse(l2Date1, l2formatter);
            LocalDate l2date1 = LocalDate.parse(l2Date2, l2formatter);
            leasedb2.setCustomer(c1);
            leasedb2.setDateStart(l2date);
            leasedb2.setDateEnd(l2date1);
            leasedb2.setStatus("not paid");
            leasedb2.setStaff(st1);
            leasedb2.setProduct(pt1);
            leaseRepository.save(leasedb2);

            Lease leasedb3 = new Lease();
            String l2Date12 = "07:07:1998";
            String l2Date22 = "06:07:1998";
            DateTimeFormatter l2formatter2 = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate l2date2 = LocalDate.parse(l2Date12, l2formatter2);
            LocalDate l2date12 = LocalDate.parse(l2Date22, l2formatter2);
            leasedb3.setCustomer(c2);
            leasedb3.setDateStart(l2date2);
            leasedb3.setDateEnd(l2date12);
            leasedb3.setStatus("not paid");
            leasedb3.setStaff(st1);
            leasedb3.setProduct(pt1);
            leaseRepository.save(leasedb3);

            Selling sellingdb = new Selling();
            sellingRepository.save(sellingdb);
            String sDate2 = "20:04:1998";
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd:MM:yyyy");
            LocalDate sdate = LocalDate.parse(sDate2, formatter2);

            sellingdb.setSellingDate(sdate);
            sellingdb.setCustomer(c2);
            sellingdb.setStaff(st1);
            sellingdb.setStatus("not paid");
            sellingdb.setProduct(pt1);
            sellingRepository.save(sellingdb);

            Lease lid = leaseRepository.findByLeaseId(1L);

            Stream.of(1L).forEach(pmid -> {
                PayMent paymentdb = new PayMent();
                paymentdb.setPmId(pmid);
                Date paydate = new Date();
                payMentRepository.save(paymentdb);

                if (pmid == 1L) {
                    paymentdb.setTypePay("Lease");
                    paymentdb.setCustomer(c1);
                    paymentdb.setDatePay(paydate);
                    paymentdb.setLease(lid);
                    paymentdb.setStatusPay("paid");
                    payMentRepository.save(paymentdb);
                }
            });

            System.out.println("\n Spring-Boot Complete");
        };
    }
}