import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import {STOCKINGService} from '../service/stocking.service';
import { DataSource } from '@angular/cdk/collections';
import { Observable } from 'rxjs/Observable';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
export interface StockElement {
  productID: String;
  productName: String;
  productPrice: number;
  productQuantity: number;
  type: {
    typeName: String;
  };
  status: {
    statusProduct: String;
  };
  productDate: Date;
}
@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})

export class StockComponent implements OnInit {
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  type: Array<any>;
  detail: Array<any>;
  description: Array<any>;
  status: Array<any>;
  product: Array<any>;
  views: any = {
    productID: '',
    productName: '',
    productQuantity: '',
    productPrice : '',
    statusSelect: '',
    typeSelect: '',
    detailSelect: '',
    prodID : '',
    detID : '',
    data: '',
    selectProductID: '',
    selectProductName: '',
    selectProductQuantity: '',
    selectProductDate: '',
    selectProductPrice : '',
    selectStatus : '',
    selectType : '',
    selectDetail: '',
    selectData: '',
    selectPID: ''
  };
  displayedColumns: string[] = ['PID', 'productID', 'productName', 'productPrice', 'productQuantity', 'types', 'statuses'];
  displayedColumnss: string[] = ['PID', 'productID', 'detail', 'data'];
  dataSource = new StockDataSource(this.STOCKService);
  myControl = new FormControl();
  constructor(private STOCKService: STOCKINGService, private httpClient: HttpClient, private _formBuilder: FormBuilder) {
  }
  ngOnInit() {
    this.STOCKService.getType().subscribe(data => {
      this.type = data;
      console.log(this.type);
    });
    this.STOCKService.getStatus().subscribe(data => {
      this.status = data;
      console.log(this.status);
    });
    this.STOCKService.getProduct().subscribe(data => {
      this.product = data;
      console.log(this.product);
    });
    this.STOCKService.getDetail().subscribe(data => {
      this.detail = data;
      console.log(this.detail);
    });
    this.STOCKService.getDescription().subscribe(data => {
      this.description = data;
      console.log(this.description);
    });
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
  }
  delete() {
    this.httpClient.delete('http://localhost:8080/product/delete/' + this.views.prodID )
      .subscribe(
        data => {
          alert('delete completed');
          console.log('Delete Request is successful', data);
          window.location.reload();
        },
        error => {
          alert('delete uncompleted');
          console.log('Error', error);
        }
      );
  }
   selectRow(row) {
     this.views.selectPID = row.prodId;
    this.views.selectProductID = row.productIds;
    this.views.selectProductName = row.productName;
    this.views.selectProductPrice = row.productPrice;
    this.views.selectProductQuantity = row.productQuantity;
    this.views.selectStatus = row.status.stateId;
    this.views.selectType = row.type.typeIds;
     console.log( this.views.selectProductName);
     console.log(this.views.selectProductPrice);
     console.log( this.views.selectProductQuantity);
     console.log( this.views.selectStatus);
     console.log(this.views.selectType);
     console.log(this.views.selectProductIds);
  }
  electRow(row) {
    this.views.selectPID = row.product.prodId;
    this.views.selectProductID = row.product.productIds;
    this.views.selectDetail = row.detail.detailName;
    this.views.selectData = row.dataDescription;
    console.log(this.views.selectProductID);
    console.log(this.views.selectDetail);
    console.log(this.views.selectData);
  }
 updateproduct() {
   this.views.prodID = this.views.selectPID;
   if (!this.views.productID) {
     this.views.productID = this.views.selectProductID;
   }
   if (!this.views.productName) {
     this.views.productName = this.views.selectProductName;
   }
   if (!this.views.productQuantity) {
     this.views.productQuantity = this.views.selectProductQuantity;
   }
   if (!this.views.productPrice) {
     this.views.productPrice = this.views.selectProductPrice;
   }
   console.log(this.views.productName);
   console.log(this.views.productQuantity);
   console.log(this.views.typeSelect);
   console.log(this.views.productDate);
   this.httpClient.put('http://localhost:8080/product/updateproduct/' + this.views.prodID + '/'
   + this.views.productID + '/' + this.views.productName + '/'
     + this.views.productPrice + '/' +  this.views.productQuantity
     , this.views)
     .subscribe(
       data => {
         if (data)  {
           alert('edit completed');
           console.log('Success');
           window.location.reload();
         }
       },
       error => {
         alert('edit uncompleted');
         console.log('Uncomplete',  error);
       }
     );
 }
  updatedetail() {
    this.views.prodID = this.views.selectPID;
    if (!this.views.detID) {
      this.views.detID = this.views.selectDetail;
    }
    if (!this.views.data) {
      this.views.data = this.views.selectData;
    }
    console.log(this.views.prodID);
    console.log(this.views.detID);
    console.log(this.views.data);
    this.httpClient.put('http://localhost:8080/description/updatedetail/' + this.views.prodID + '/'
    + this.views.detID + '/' + this.views.data,
      this.views, )
      .subscribe(
        data => {
          if (data)  {
            alert('edit completed');
            console.log('Success');
            window.location.reload();
          }
        },
        error => {
          alert('edit uncompleted');
          console.log('Uncomplete',  error);
        }
      );
  }
  addproduct() {
    if (this.views.productID === '') {
      alert('Please insert ID');
    } else if (this.views.productName === '') {
      alert('Please insert Product Name');
    } else if (this.views.productPrice === '') {
      alert('Please insert Product Price');
    } else if (this.views.productQuantity === '') {
      alert('Please insert Product Quantity');
    } else if (this.views.productDate === '') {
      alert('Please insert Date');
    } else {
      this.httpClient.post('http://localhost:8080/product/add/' + this.views.productID + '/' + this.views.productName
        + '/' + this.views.productPrice + '/' + this.views.productQuantity + '/' + this.views.productDate + '/'
        + this.views.statusSelect + '/' + this.views.typeSelect, this.views)
        .subscribe(
          data => {
            alert('input complete');
            console.log('INPUT Request is successful', data);
            window.location.reload();
          },
          error => {
            alert('input uncompleted');
            console.log('Error', error);
          }
        );
    }
    console.log(this.views.productID);
    console.log(this.views.productName);
    console.log(this.views.productPrice);
    console.log(this.views.productQuantity);
    console.log(this.views.productDate);
    console.log(this.views.statusSelect);
    console.log(this.views.typeSelect);


  }
  adddetail() {
    this.httpClient.post('http://localhost:8080/description/' +  this.views.prodID + '/' + this.views.detID + '/' + this.views.data,
      this.views, ) .subscribe(
          data => {
            alert('input complete');
            console.log('INPUT Request is successful', data);
             window.location.reload();
          },
          error => {
            alert('input uncompleted');
            console.log('Error', error);
          }
        );
    }
}
export class StockDataSource extends DataSource<any> {
  constructor(private stockService: STOCKINGService) {
    super();
  }
  connect(): Observable<StockElement[]> {
    return this.stockService.getProduct();
  }
  disconnect() {}
}
