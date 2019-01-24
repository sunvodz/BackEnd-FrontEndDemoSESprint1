import { Component, OnInit } from '@angular/core';
import {ViewChild} from '@angular/core';
import {MatSort} from '@angular/material';
import { HttpClient} from '@angular/common/http';
import {RegisterService} from '../service/register.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit  {
  displayedColumns: string [] = ['staffIds', 'staffName', 'staffGender'
    , 'educationId', 'staffPhone' , 'staffJobtype', 'staffSalary', 'positionId' , 'experienceId'];
  Experiences: Array<any>;
  Positions: Array<any>;
  positionName: Array<any>;
  staffGender: Array<any>;
  staffSalary:  Array<any>;
  staffPhone: Array<any>;
  Staffs: Array<any>;
  education: Array<any>;
  staffId: Array<any>;
  staffName: Array<any>;
  experienceId: Array<any>;
  experienceName: Array<any>;
  Educations: Array<any>;
  positionId: Array<any>;
  Position: Array<any>;
  educationName: Array<any>;
  Experience: Array<any>;
  staffJobtype: Array<any>;
  staffIds: Array<any>;
  Staff = {
    staffIds: 'St' + this.staffId
  };

  views: any = {
    Position: '',
    staffId: '',
    positionId: '',
    staffJobtype: '',
    staffGender: '',
    educationId: '',
    experienceId: '',
    experience: '',
    staffIds: '',
    staffName: '',
    staffPhone: '',
    staffSalary : '',
    SelectStaffId: '',
    SelectStaffIds: '',
    SelectStaffName: '',
    SelectStaffPhone: '',
    SelectStaffSalary : '',
    SelectStaffJobtype : '',
    SelectPositionId : '',
    SelectExperienceId : '',
    SelectStaffGender : '',
    SelectEducationId : ''
  };

  @ViewChild(MatSort)
  sort: MatSort;

  constructor(private registerservice: RegisterService, private httpClient: HttpClient ) {}

  ngOnInit() {

    this.registerservice.getPosition().subscribe(data => {
      this.Positions = data;
      console.log(this.Positions);
    });
    this.registerservice.getExperience().subscribe(data => {
      this.Experiences = data;
      console.log(this.Experiences);
    });
    this.registerservice.getStaff().subscribe(data => {
      this.Staffs = data;
      console.log(this.Staffs);
    });
    this.registerservice.getEducation().subscribe(data => {
      this.Educations = data;
      console.log(this.Educations);
    });
  }

  selectRow(row) {
    this.views.SelectStaffId = row.staffId;
    this.views.SelectStaffIds = row.staffIds;
    this.views.SelectStaffName = row.staffName;
    this.views.SelectStaffGender = row.staffGender;
    this.views.SelectEducationId = row.education.educationId;
    this.views.SelectStaffPhone = row.staffPhone;
    this.views.SelectStaffJobtype = row.staffJobtype;
    this.views.SelectStaffSalary = row.staffSalary;
    this.views.SelectPositionId = row.position.positionId;
    this.views.SelectExperienceId = row.experience.experienceId;
    console.log( this.views.SelectStaffId);
    console.log( this.views.SelectStaffIds);
    console.log( this.views.SelectStaffName);
    console.log( this.views.SelectStaffGender);
    console.log( this.views.SelectEducationId);
    console.log( this.views.SelectStaffPhone);
    console.log( this.views.SelectStaffJobtype);
    console.log( this.views.SelectStaffSalary);
    console.log( this.views.SelectPositionId);
    console.log( this.views.SelectExperienceId);
  }

  Post() {
    this.httpClient.post('http://localhost:8080/staffs/'  + this.views.staffName + '/' + this.views.staffGender
      + '/' + this.views.educationId + '/' + this.views.staffPhone + '/' + this.views.staffJobtype + '/' + this.views.staffSalary + '/'
      + this.views.positionId + '/' + 'Un Paid' + '/' + this.views.experienceId, this.Staffs)

      .subscribe(
        data => {
          console.log('Save Completed', data);
          alert('Save Completed');
          window.location.reload();
        },
        error => {
          console.log('Save Uncompleted', error);
          alert('Save Uncompleted');
        }

      );
  }

  Update() {
    this.views.staffId = this.views.SelectStaffId;
    this.views.staffIds = this.views.SelectStaffIds;

    if (!this.views.staffName) {
      this.views.staffName = this.views.SelectStaffName;
    }
    if (!this.views.staffPhone) {
      this.views.staffPhone = this.views.SelectStaffPhone;
    }
    if (!this.views.staffSalary) {
      this.views.staffSalary = this.views.SelectStaffSalary;
    }
    if (!this.views.staffGender) {
      this.views.staffGender = this.views.SelectStaffGender;
    }
    if (!this.views.educationId) {
      this.views.educationId = this.views.SelectEducationId;
    }
    if (!this.views.positionId) {
      this.views.positionId = this.views.SelectPositionId;
    }
    if (!this.views.staffJobtype) {
      this.views.staffJobtype = this.views.SelectStaffJobtype;
    }
    if (!this.views.experienceId) {
      this.views.experienceId = this.views.SelectExperienceId;
    }
    console.log('---Update Register---');
    console.log(this.views.staffId);
    console.log(this.views.staffIds);
    console.log(this.views.staffName);
    console.log(this.views.staffPhone);
    console.log(this.views.staffSalary);
    console.log(this.views.staffGender);
    console.log(this.views.educationId);
    console.log(this.views.positionId);
    console.log(this.views.staffJobtype);
      console.log(this.views.experienceId);
    this.httpClient.put('http://localhost:8080/staffupdate/' + this.views.SelectStaffId + '/'
    + this.views.SelectStaffIds + '/' + this.views.staffName + '/' + this.views.staffPhone + '/'
      + this.views.staffSalary + '/' + 'Un Paid' + '/' + this.views.positionId + '/' +
       this.views.educationId + '/' + this.views.staffGender + '/' + this.views.staffJobtype
       + '/' + this.views.experienceId , this.Staffs)
      .subscribe(
        data => {
          if (data)  {
            alert('Edit Completed');
            console.log('Edit Completed');
            window.location.reload();
          }
        },
        error => {
          alert('Edit Uncompleted');
          console.log('Uncomplete',  error);
        }
      );
  }
}
