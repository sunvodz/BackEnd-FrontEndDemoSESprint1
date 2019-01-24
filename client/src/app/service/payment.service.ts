import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PaymentService {

  constructor(private http: HttpClient) {}

getStaff(): Observable<any> {
    return this.http.get('//localhost:8080/pstaff');
}
getCustomer(): Observable<any> {
    return this.http.get('//localhost:8080/pcustomer');
}
 getPayment(): Observable<any> {
   return this.http.get('//localhost:8080/payment');
 }
getSelling(): Observable<any> {
  return this.http.get('//localhost:8080/pselling');
}
getCustomerSearchS(id): Observable<any> {
  return this.http.get('//localhost:8080/pselling/' + id);
}
getBooking(): Observable<any> {
  return this.http.get('//localhost:8080/pbooking');
}
getCustomerSearchB(id): Observable<any> {
  return this.http.get('//localhost:8080/pbooking/' + id);
}
getLease(): Observable<any> {
  return this.http.get('//localhost:8080/please');
}
getCustomerSearchL(id): Observable<any> {
  return this.http.get('//localhost:8080/please/' + id);
}
}


