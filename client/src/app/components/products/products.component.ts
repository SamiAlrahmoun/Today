import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  @Input() product: any;
  @Output() productAdded = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }
  products = [
    {id: 1,name: 'Shoes', price: 8799},
    {id:2,name: 'shubert helmet', price: 999},
    {id:3,name: 'sport gloves', price: 99}
  ];
  cartProductList = [];

  addProductToCart(product) {
    console.log("Product is added");
    this.productAdded.emit(product);
    // const productExistInCart = this.cartProductList.find(({name}) => name === product.name); // find product by name
    // if (!productExistInCart) {
    //   this.cartProductList.push({...product, num:1}); // enhance "porduct" opject with "num" property
    //   return;
    // }
    // productExistInCart.num += 1;
  }
  removeProduct(product) {
    this.cartProductList = this.cartProductList.filter(({name}) => name !== product.name)
  }

}
