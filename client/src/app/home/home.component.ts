import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  hide = true;

  loginuser = {
    userName: '',
    upassword: '',
    adminName: '',
    apassword: ''
  };

  constructor( private router: Router ) { }

  ngOnInit() {
  }
  loginUser() {
    if (this.loginuser.userName === '' ||
    this.loginuser.upassword ===  ''
    ) {
     alert('กรอกข้อมูลให้ครบถ้วน');
  } else if (this.loginuser.userName === 'sunvo' ||
  this.loginuser.userName === 'ploy' ||
  this.loginuser.userName === 'Ao' ||
      this.loginuser.userName === 'Wahn' ||
      this.loginuser.userName === 'Opal' ||
      this.loginuser.userName === 'Meen' &&
  this.loginuser.upassword ===  '123456' ) {
    this.router.navigate(['/makeup']);
    alert('เข้าสู่ระบบ');
  } else {
    alert('รหัสไม่ถูกต้อง');
  }
  }

  loginAdmin() {
    if (this.loginuser.adminName === '' ||
    this.loginuser.apassword ===  ''
    ) {
     alert('กรอกข้อมูลให้ครบถ้วน');
  } else if (this.loginuser.adminName === 'admin' &&
  this.loginuser.apassword ===  '123456' ) {
    this.router.navigate(['/payment']);
    alert('เข้าสู่ระบบ');
  } else {
    alert('รหัสไม่ถูกต้อง');
  }
  }
}

