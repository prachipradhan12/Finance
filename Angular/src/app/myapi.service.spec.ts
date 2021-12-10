import { TestBed } from '@angular/core/testing';

import { MyapiService } from './myapi.service';

describe('MyapiService', () => {
  let service: MyapiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyapiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
