import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PaymentService } from '../service/payment.service';
import {MatTableDataSource} from '@angular/material';

  export interface Searchidl {
    Memberid: String;
  }
  export interface Searchids {
    Memberid: String;
  }
  export interface Searchidb {
    Memberid: String;
  }

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})

export class PaymentComponent implements OnInit {
  displayedColumnsH: string[] = ['pmId', 'datePay', 'typePay', 'statusPay', 'customerName'];
  displayedColumns: string[] = ['Memberid', 'UserName', 'Name', 'Price', 'Status'];
  CurrentDate = new Date();

  filter: '';
  members: Array<any>;
  dataSourcel = new MatTableDataSource<Searchidl>(this.members);
  dataSources = new MatTableDataSource<Searchids>(this.members);
  dataSourceb = new MatTableDataSource<Searchidb>(this.members);
  staffs: Array<any>;
  payment: Array<any>;
  lease: Array<any>;
  selling: Array<any>;
  booking: Array<any>;
  userid: Array<any>;
  username: Array<any>;

  LeaseId: Array<any>;
  LeaseName: Array<any>;
  LeasePrice: Array<any>;
  LeaseStatus: Array<any>;

  SellingId: Array<any>;
  SellingName: Array<any>;
  SellingPrice: Array<any>;
  StatusSelling: Array<any>;

  BookingId: Array<any>;
  BookingStyleName: Array<any>;
  BookingPrice: Array<any>;
  StatusBooking: Array<any>;

  userData = {
    userid : '',
    username: ''
  };

  payments: any = {
    LeaseId: '',
    LeaseName: '',
    LeasePrice: '',
    LeaseStatus: '',

    SellingId: '',
    SellingName: '',
    SellingPrice: '',
    StatusSelling: '',

    BookingId: '',
    BookingStyleName: '',
    BookingPrice: '',
    StatusBooking: '',

    selectLeaseName: '',
    selectLeasePrice: '',
    selectLeaseStatus: '',

    selectSellingName: '',
    selectSellingPrice: '',
    selectStatusSelling: '',

    selectBookingStyleName: '',
    selectBookingPrice: '',
    selectStatusBooking: ''
  };

  constructor(private paymentService: PaymentService, private httpClient: HttpClient) { }


  ngOnInit() {

    this.paymentService.getPayment().subscribe(data => {
      this.payment = data;
      console.log(this.payment);
    });
    this.paymentService.getStaff().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });
    this.paymentService.getSelling().subscribe(data => {
      this.dataSources = data;
      console.log(this.selling);
    });
    this.paymentService.getBooking().subscribe(data => {
      this.dataSourceb = data;
      console.log(this.booking);
    });
    this.paymentService.getLease().subscribe(data => {
      this.dataSourcel = data;
      console.log(this.lease);
    });
  }

  searchIdl(id) {
  this.paymentService.getCustomerSearchL(id).subscribe(data => {
    this.dataSourcel = data;
    console.log(this.lease);
  });
  }
  searchIds(id) {
    this.paymentService.getCustomerSearchS(id).subscribe(data => {
      this.dataSources = data;
      console.log(this.selling);
    });
  }
  searchIdb(id) {
    this.paymentService.getCustomerSearchB(id).subscribe(data => {
      this.dataSourceb = data;
      console.log(this.booking);
    });
  }
  viewLease(row) {
    this.userData.userid = row.customer.customerIDs;
    this.userData.username = row.customer.customerName;
    this.payments.selectLeaseId = row.leaseId;
    this.payments.selectLeaseName = row.product.productName;
    this.payments.selectLeasePrice = row.product.productPrice;
    this.payments.selectLeaseStatus = row.status;
    console.log('SelectLease successful');
 }
 viewSelling(row) {
  this.userData.userid = row.customer.customerIDs;
  this.userData.username = row.customer.customerName;
  this.payments.selectSellingId = row.sellingId;
  this.payments.selectSellingName = row.product.productName;
  this.payments.selectSellingPrice = row.product.productPrice;
  this.payments.selectStatusSelling = row.status;
  console.log('SelectSelling successful');
}
viewBooking(row) {
  this.userData.userid = row.customer.customerIDs;
  this.userData.username = row.customer.customerName;
  this.payments.selectBookingId = row.bookingId;
  this.payments.selectBookingStyleName = row.style.styleName;
  this.payments.selectBookingPrice = row.style.stylePrice;
  this.payments.selectStatusBooking = row.status;
  console.log('SelectBooking successful');
}

  payLeaseButtom() {
    if ( this.userData.userid === '' ||
     this.payments.selectLeaseId === '' ) {
     alert('ข้อมูลไม่ครบถ้วน');
} else {
  this.httpClient.post('http://localhost:8080/payment/' + 'Lease' + '/' + 'paid' + '/' + this.userData.userid +
                                                    '/' + 0 + '/' + 0 + '/' + this.payments.selectLeaseId, this.payment)
  .subscribe(
    data => {
      window.location.reload();
        console.log('Post successful', data);
        alert('สำเร็จ');
    },
    error => {
        console.log('Error', error);
    }
);
this.httpClient.put('http://localhost:8080/lease/' + this.payments.selectLeaseId + '/' + 'paid', this.lease)
    .subscribe(
      data => {
        if (data) {
          console.log('Success');
        }
      },
      error => {
      console.log('error', error);
    }
    );

  }
}
  paySellingButtom() {
    if (this.userData.userid === '' || this.payments.selectSellingId === '' ) {
     alert('ข้อมูลไม่ครบถ้วน');
} else {
  this.httpClient.post('http://localhost:8080/payment/' + 'Selling' + '/' + 'paid' + '/' + this.userData.userid +
                                                    '/' + this.payments.selectSellingId + '/' + 0 + '/' + 0, this.payment)
  .subscribe(
    data => {
      window.location.reload();
        console.log('Post successful', data);
        alert('สำเร็จ');
    },
    error => {
        console.log('Error', error);
    }
);
this.httpClient.put('http://localhost:8080/selling/' + this.payments.selectSellingId + '/' + 'paid', this.selling)
    .subscribe(
      data => {
        if (data) {
          console.log('Success');
        }
      },
      error => {
      console.log('error', error);
    }
    );
  }
  }
  payBookingButtom() {
    if (this.userData.userid === '' || this.payments.selectBookingId === '' ) {
   alert('ข้อมูลไม่ครบถ้วน');
} else {
this.httpClient.post('http://localhost:8080/payment/' + 'Booking' + '/' + 'paid' + '/' + this.userData.userid +
                                                  '/' + 0 + '/' + this.payments.selectBookingId + '/' + 0, this.payment)
.subscribe(
  data => {
    window.location.reload();
      console.log('Post successful', data);
      alert('สำเร็จ');
  },
  error => {
      console.log('Error', error);
  }
);
this.httpClient.put('http://localhost:8080/booking/' + this.payments.selectBookingId + '/' + 'paid', this.booking)
    .subscribe(
      data => {
        if (data) {
          console.log('Success');
        }
      },
      error => {
      console.log('error', error);
    }
    );
}

}
}




