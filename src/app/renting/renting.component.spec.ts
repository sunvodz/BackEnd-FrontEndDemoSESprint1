import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentingComponent } from './renting.component';

describe('RentingComponent', () => {
  let component: RentingComponent;
  let fixture: ComponentFixture<RentingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
