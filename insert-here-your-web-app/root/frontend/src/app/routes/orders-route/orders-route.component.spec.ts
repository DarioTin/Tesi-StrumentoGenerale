import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersRouteComponent } from './orders-route.component';

describe('OrdersRouteComponent', () => {
  let component: OrdersRouteComponent;
  let fixture: ComponentFixture<OrdersRouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdersRouteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdersRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
