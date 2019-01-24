import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class MakeupService {
  constructor(private http: HttpClient) { }
  getStaff(): Observable<any> {
    return this.http.get('//localhost:8080/staff');
  }
  getPosition(): Observable<any> {
    return this.http.get('//localhost:8080/position');
  }
  getCustomer(): Observable<any> {
    return this.http.get('//localhost:8080/customer');
  }
  getBooking(): Observable<any> {
    return this.http.get('//localhost:8080/booking');
  }
  getStyle(): Observable<any> {
    return this.http.get('//localhost:8080/style');
  }
}
