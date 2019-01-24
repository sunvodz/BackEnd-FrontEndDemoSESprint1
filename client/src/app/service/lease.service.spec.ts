import { TestBed, inject } from '@angular/core/testing';

import { LeaseService } from './lease.service';

describe('LeaseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LeaseService]
    });
  });

  it('should be created', inject([LeaseService], (service: LeaseService) => {
    expect(service).toBeTruthy();
  }));
});
