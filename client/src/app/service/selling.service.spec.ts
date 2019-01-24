import { TestBed, inject } from '@angular/core/testing';

import { SellingService } from './selling.service';

describe('SellingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SellingService]
    });
  });

  it('should be created', inject([SellingService], (service: SellingService) => {
    expect(service).toBeTruthy();
  }));
});
