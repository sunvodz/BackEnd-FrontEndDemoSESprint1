import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) {
  }
  getStaff(): Observable<any> {
    return this.http.get('//localhost:8080/staff');
  }
  getPosition(): Observable<any> {
    return this.http.get('//localhost:8080/position');
  }
  getExperience(): Observable<any> {
    return this.http.get('//localhost:8080/experience');
  }
  getEducation(): Observable<any> {
    return this.http.get('//localhost:8080/education');
  }
}
