import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})

export class LeaseService {

  constructor(private http: HttpClient) {

  }
  getStaff(): Observable<any> {
    return this.http.get('//localhost:8080/staffRenter');
  }
  getCustomer(): Observable<any> {
    return this.http.get('//localhost:8080/customer');
  }
  getProduct(): Observable<any> {
    return this.http.get('//localhost:8080/product');
  }
  getLease(): Observable<any> {
    return this.http.get('//localhost:8080/lease');
  }
}
