import { TestBed } from '@angular/core/testing';

import { CategoriaSService } from './categoria-s.service';

describe('CategoriaSService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CategoriaSService = TestBed.get(CategoriaSService);
    expect(service).toBeTruthy();
  });
});
