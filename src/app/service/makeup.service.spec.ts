import { TestBed, inject } from '@angular/core/testing';

import { MakeupService } from './makeup.service';

describe('MakeupService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MakeupService]
    });
  });

  it('should be created', inject([MakeupService], (service: MakeupService) => {
    expect(service).toBeTruthy();
  }));
});
