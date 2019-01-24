import {Component, OnInit, ViewChild} from '@angular/core';
import { LeaseService } from '../service/lease.service';
import {MatSort} from '@angular/material';
import { HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';


@Component ( {
  selector: 'app-renting',
  templateUrl: './renting.component.html',
  styleUrls: ['./renting.component.css']
})
export class RentingComponent implements OnInit {

  displayedColumns1: string[] = ['productID', 'productName', 'productPrice', 'productStatus'];
  displayedColumns2: string[] = ['staffID', 'staffName', 'position'];
  Staffs: Array<any>;
  Product: Array<any>;
  customerID: Array<any>;
  ReserveDate: Array<any>;
  ReturnDate: Array<any>;
  Customers: Array<any>;
  Leases: Array<any>;
  addressCustomer: Array<any>;
  staffIDs: Array<any>;
  productName: Array<any>;
  productID: Array<any>;
  productPrice: Array<any>;
  statusProduct: Array<any>;

  views: any = {
    productID: '',
    productName: '',
    productPrice : '',
    selectProductID: '',
    selectProductName: '',
    selectProductPrice : ''
  };

  pipe = new DatePipe('en-US');
  @ViewChild(MatSort)
  sort: MatSort;

  constructor(private leaseservice: LeaseService, private httpClient: HttpClient, private router: Router) {

  }

  ngOnInit() {
    this.leaseservice.getLease().subscribe(data => {
      this.Leases = data;
      console.log(this.Leases);
    });
    this.leaseservice.getCustomer().subscribe(data => {
      this.Customers = data;
      console.log(this.Customers);
    });
    this.leaseservice.getStaff().subscribe(data => {
      this.Staffs = data;
      console.log(this.Staffs);
    });
    this.leaseservice.getProduct().subscribe(data => {
      this.Product = data;
      console.log(this.Product);
    });

  }

  save() {
    this.httpClient.post('http://localhost:8080/renting/' + this.views.selectProductID + '/'
    + this.views.selectProductName + '/' + this.views.selectProductPrice + '/'
    + this.customerID + '/' + this.staffIDs + '/' +
     this.pipe.transform(this.ReserveDate, 'dd:MM:yyyy') + '/'
      + this.pipe.transform(this.ReturnDate, 'dd:MM:yyyy'), this.Leases)
      .subscribe(
        data => {
          console.log('POST Request is successful', data);
         window.location.reload();
          alert('Finish');
        },
        error => {
          console.log('Rrror', error);
          alert(error);
        }
      );

  }
  selectRow(row) {
    this.views.selectProductID = row.productIds;
    this.views.selectProductName = row.productName;
    this.views.selectProductPrice = row.productPrice;
    console.log(this.views.selectProductID);
    console.log(this.views.selectProductName);
    console.log(this.views.selectProductPrice);
  }
}

