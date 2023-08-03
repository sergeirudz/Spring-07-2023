import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private httpClient: HttpClient) {}

  addProduct(product: Product) {
    return this.httpClient.post('http://localhost:8080/products', product);
  }

  deleteProduct(product: Product) {
    return this.httpClient.delete(
      `http://localhost:8080/products/${product.id}`
    );
  }

  editProduct(product: Product) {
    return this.httpClient.put(
      `http://localhost:8080/products/${product.id}`,
      product
    );
  }

  getProducts() {
    return this.httpClient.get<Product[]>('http://localhost:8080/products');
  }

  getProduct(product: Product) {
    return this.httpClient.get<Product>(
      `http://localhost:8080/products/${product.id}`
    );
  }
}
