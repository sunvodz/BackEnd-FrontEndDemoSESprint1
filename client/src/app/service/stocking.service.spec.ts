import { TestBed, inject } from '@angular/core/testing';

import { STOCKINGService } from './stocking.service';

describe('STOCKINGService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [STOCKINGService]
    });
  });

  it('should be created', inject([STOCKINGService], (service: STOCKINGService) => {
    expect(service).toBeTruthy();
  }));
});
