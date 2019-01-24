import { Component, OnInit } from '@angular/core';
import {ViewChild} from '@angular/core';
import {MatSort} from '@angular/material';
import {MakeupService} from '../service/makeup.service';
import { HttpClient} from '@angular/common/http';
import { Router} from '@angular/router';
import {DatePipe} from '@angular/common';

@Component ({
  selector: 'app-makeup',
  templateUrl: './makeup.component.html',
  styleUrls: ['./makeup.component.css']
})
export class MakeupComponent implements OnInit {
  displayedColumns2: string[] = ['stID', 'staffIDs', 'staffName', 'positionName'];
  displayedColumns1: string[] = ['styleID', 'styleIDs', 'styleName', 'stylePrice'];

  Bookings: Array<any>;
  Customers: Array<any>;
  Styles: Array<any>;
  Staffs: Array<any>;
  Positions: Array<any>;

  bookingDate: Array<any>;
  cusId: Array<any>;
  customerIDs: Array<any>;
  customerName: Array<any>;
  addressCustomer: Array<any>;

  stID: Array<any>;
  staffIDs: Array<any>;
  staffName: Array<any>;
  positionName: Array<any>;

  styleIDs: Array<any>;
  styleID: Array<any>;
  styleName: Array<any>;
  stylePrice: Array<any>;

  viewStyle: any = {
    styleIDs: '',
    styleID: '',
    styleName: '',
    stylePrice: ''
  };

  viewStaff: any = {
    stID: '',
    staffIDs: '',
    staffName: '',
    positionName: ''
  };

  pipe = new DatePipe('en-US');
  @ViewChild(MatSort)
  sort: MatSort;

  constructor(private makeupservice: MakeupService, private httpClient: HttpClient, private router: Router) {
  }

  ngOnInit() {

    this.makeupservice.getBooking().subscribe(data => {
      this.Bookings = data;
      console.log(this.Bookings);
    });
    this.makeupservice.getCustomer().subscribe(data => {
      this.Customers = data;
      console.log(this.Customers);
    });
    this.makeupservice.getStaff().subscribe(data => {
      this.Staffs = data;
      console.log(this.Staffs);
    });
    this.makeupservice.getPosition().subscribe(data => {
      this.Positions = data;
      console.log(this.Positions);

    });
  }

  OK() {
        this.httpClient.post('http://localhost:8080/makeupBooking/' +
        this.viewStyle.selectstyleID + '/' + this.viewStyle.selectstyleIDs + '/' +
        this.viewStyle.selectstyleName + '/' + this.viewStyle.selectstylePrice + '/' +
        this.viewStaff.selectstID + '/' + this.viewStaff.selectstaffIDs + '/' +
        this.viewStaff.selectstaffName + '/' +
        this.pipe.transform(this.bookingDate, 'dd:MM:yyyy') + '/' +
        this.cusId + '/' + this.customerIDs + '/' +
        this.customerName + '/' + this.addressCustomer , this.Bookings)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
            window.location.reload();
            alert('ยืนยันการจองเรียบร้อยแล้ว');
          },
          error => {
            console.log('Error', error);
          }
        );
  }

  selectRowStyle(row) {
    this.viewStyle.selectstyleID = row.style.styleID;
    this.viewStyle.selectstyleIDs = row.style.styleIDs;
    this.viewStyle.selectstyleName = row.style.styleName;
    this.viewStyle.selectstylePrice = row.style.stylePrice;
    console.log(this.viewStyle.selectstyleID);
    console.log(this.viewStyle.selectstyleIDs);
    console.log(this.viewStyle.selectstyleName);
    console.log(this.viewStyle.selectstylePrice);
  }
  selectRowStaff(row) {
    this.viewStaff.selectstID = row.staffId;
    this.viewStaff.selectstaffIDs = row.staffIds;
    this.viewStaff.selectstaffName = row.staffName;
    console.log(this.viewStaff.selectstID);
    console.log(this.viewStaff.selectstaffIDs);
    console.log(this.viewStaff.selectstaffName);

  }

}

