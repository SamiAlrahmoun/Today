import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  @Input() products: any[];
  @Input() product: any;
  @Output() productInCart: any;
  @Output() productRemoved = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }
  calcTotal() {
    this.productInCart =  this.products.reduce((acc, prod) => acc+= prod.num ,0)
  }
}
