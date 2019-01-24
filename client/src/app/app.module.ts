import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { PaymentComponent } from './payment/payment.component';
import {MatCheckboxModule} from '@angular/material';
import {MatButtonModule} from '@angular/material';
import {MatInputModule} from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material';
import { PaymentService } from './service/payment.service';
import { HistoryComponent } from './history/history.component';
import { HomeComponent } from './home/home.component';
import { MakeupComponent } from './makeup/makeup.component';
import { MakeupService } from './service/makeup.service';
import { SellingService} from './service/selling.service';
import { SellComponent } from './sell/sell.component';
import { RentingComponent } from './renting/renting.component';
import { LeaseService } from './service/lease.service';
import { MenucustomerComponent } from './menucustomer/menucustomer.component';
import { MenuadminComponent } from './menuadmin/menuadmin.component';
import { RegisterService } from './service/register.service';
import { RegisterComponent } from './register/register.component';
import { StockComponent} from './stock/stock.component';
import {STOCKINGService} from './service/stocking.service';
const appRoutes: Routes = [
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PaymentComponent,
    HistoryComponent,
    MakeupComponent,
    SellComponent,
    RentingComponent,
    MenucustomerComponent,
    MenuadminComponent,
    StockComponent,
    RegisterComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    RouterModule.forRoot([
      {path: 'home', component: HomeComponent},
      {path: 'payment', component: PaymentComponent},
      {path: 'history', component: HistoryComponent},
      {path: 'makeup', component: MakeupComponent},
      {path: 'selling', component: SellComponent},
      {path: 'renting', component: RentingComponent},
      {path: 'stock' , component: StockComponent},
      {path: 'register' , component: RegisterComponent},
      {path: '', component: HomeComponent}
    ])
  ],
  providers: [PaymentService , MakeupService , SellingService , LeaseService , RegisterService , STOCKINGService],
  bootstrap: [AppComponent]
})
export class AppModule { }
