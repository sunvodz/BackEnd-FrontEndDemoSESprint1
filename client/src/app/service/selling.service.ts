import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SellingService {

  constructor(private http: HttpClient) {
  }

  getStaff(): Observable<any> {
    return this.http.get('//localhost:8080/staffSeller');
  }
  getCustomer(): Observable<any> {
    return this.http.get('//localhost:8080/customer');
  }
  getProduct(): Observable<any> {
    return this.http.get('//localhost:8080/productSelling');
  }
}
