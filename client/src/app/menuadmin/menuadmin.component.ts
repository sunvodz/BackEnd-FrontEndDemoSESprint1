import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../service/payment.service';

@Component({
  selector: 'app-menuadmin',
  templateUrl: './menuadmin.component.html',
  styleUrls: ['./menuadmin.component.css']
})
export class MenuadminComponent implements OnInit {
  title = 'Renting and Dressing System';
  staffs: Array<any>;
  constructor(private paymentService: PaymentService) {
    this.paymentService.getStaff().subscribe(data => {
    this.staffs = data;
    console.log(this.staffs);
  }); }

  ngOnInit() {
  }

}
