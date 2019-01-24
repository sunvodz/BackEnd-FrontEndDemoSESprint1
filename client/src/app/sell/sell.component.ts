import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { SellingService } from '../service/selling.service';
import {MatSort} from '@angular/material';
import {Router} from '@angular/router';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {
  displayedColumns1: string[] = ['productID', 'productName', 'productPrice', 'statusProduct'];
  displayedColumns2: string[] = ['staffIDs', 'staffName', 'position'];
  Customers: Array<any>;
  customerID: Array<any>;

  Staffs: Array<any>;
  staffIDs: Array<any>;
  staffName: Array<any>;
  position: Array<any>;

  Sellings: Array<any>;
  sellingDate: Array<any>;
  pipe = new DatePipe('en-US');

  Products: Array<any>;
  productID: Array<any>;
  productName: Array<any>;
  statusProduct: Array<any>;
  productPrice: Array<any>;

  views: any = {
    productID: '',
    productName: '',
    productPrice : '',
    selectProductID: '',
    selectProductName: '',
    selectProductPrice : '',
  };

  @ViewChild(MatSort)
  sort: MatSort;
  constructor(private sellingService: SellingService, private httpClient: HttpClient, private router:
    Router) { }

  ngOnInit() {
    this.sellingService.getCustomer().subscribe(data => {
      this.Sellings = data;
      console.log(this.Sellings);
    });
    this.sellingService.getCustomer().subscribe(data => {
      this.Customers = data;
      console.log(this.Customers);
    });
    this.sellingService.getStaff().subscribe(data => {
      this.Staffs = data;
      console.log(this.Staffs);
    });
    this.sellingService.getProduct().subscribe(data => {
      this.Products = data;
      console.log(this.Products);
    });
  }
  save() {
    this.httpClient.post( 'http://localhost:8080/sell/' + this.views.selectProductID + '/' + this.views.selectProductName + '/'
      + this.views.selectProductPrice + '/' + this.customerID + '/' + this.staffIDs + '/'
      + this.pipe.transform(this.sellingDate, 'dd:MM:yyyy'), this.Sellings)
      .subscribe(
        data => {
          console.log('POST Request is successful', data);
          window.location.reload();
          alert('Finish');
        },
        error => {
          console.log('Rrror', error );
          alert('error');
        });
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

