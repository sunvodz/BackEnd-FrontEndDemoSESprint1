import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../service/payment.service';


@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  title = 'Renting and Dressing System';
  staffs: Array<any>;
  payment: Array<any>;

  displayedColumns: string[] = ['pmId', 'datePay', 'typePay', 'statusPay', 'customerName'];

  constructor(private paymentService: PaymentService) { }

  ngOnInit() {
    this.paymentService.getPayment().subscribe(data => {
      this.payment = data;
      console.log(this.payment);
    });
    this.paymentService.getStaff().subscribe(data => {
      this.staffs = data;
      console.log(this.staffs);
    });
  }

}

