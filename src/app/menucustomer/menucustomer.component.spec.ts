import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenucustomerComponent } from './menucustomer.component';

describe('MenucustomerComponent', () => {
  let component: MenucustomerComponent;
  let fixture: ComponentFixture<MenucustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenucustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenucustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
