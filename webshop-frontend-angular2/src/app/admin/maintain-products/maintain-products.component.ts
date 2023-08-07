import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-maintain-products',
  templateUrl: './maintain-products.component.html',
  styleUrls: ['./maintain-products.component.scss'],
})
export class MaintainProductsComponent {
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.productService.getProducts().subscribe((res) => (this.products = res));
  }

  deleteProduct(product: Product) {
    this.productService
      .deleteProduct(product)
      .subscribe((res) => (this.products = res));
  }

  decreaseStock(product: Product) {
    this.productService
      .decreaseStock(product.id as Pick<Product, 'id'>)
      .subscribe((res) => (this.products = res));
  }

  increaseStock(product: Product) {
    this.productService
      .increaseStock(product.id as Pick<Product, 'id'>)
      .subscribe((res) => (this.products = res));
  }
}
