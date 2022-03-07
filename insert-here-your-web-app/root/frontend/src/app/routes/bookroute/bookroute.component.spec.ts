import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookrouteComponent } from './bookroute.component';

describe('BookrouteComponent', () => {
  let component: BookrouteComponent;
  let fixture: ComponentFixture<BookrouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookrouteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookrouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
