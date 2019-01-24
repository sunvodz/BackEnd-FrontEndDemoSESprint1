import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})

export class STOCKINGService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getDetail(): Observable<any> {
    return this.http.get(this.API + '/detail');
  }
  getDescription(): Observable<any> {
    return this.http.get(this.API + '/description');
  }
  getProduct(): Observable<any> {
    return this.http.get(this.API + '/product');
  }
  getType(): Observable<any> {
    return this.http.get(this.API + '/type');
  }
  getStatus(): Observable<any> {
    return this.http.get(this.API + '/status');
  }
}
