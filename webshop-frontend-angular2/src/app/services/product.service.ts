import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../models/product.model';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private url = environment.baseUrl + '/products';

  constructor(private httpClient: HttpClient) {}

  addProduct(product: Product) {
    return this.httpClient.post(`${this.url}`, product);
  }

  deleteProduct(product: Product) {
    return this.httpClient.delete<Product[]>(`${this.url}` + product.id);
  }

  getProducts() {
    return this.httpClient.get<Product[]>(`${this.url}`);
  }

  getProduct(id: number) {
    return this.httpClient.get<Product>(`${this.url}` + id);
  }

  editProduct(product: Product) {
    return this.httpClient.put(`${this.url}` + product.id, product);
  }

  decreaseStock(id: Pick<Product, 'id'>) {
    return this.httpClient.patch<Product[]>(
      environment.baseUrl + '/decrease-stock/' + id,
      {}
    );
  }

  increaseStock(id: Pick<Product, 'id'>) {
    console.log('product', id);
    return this.httpClient.patch<Product[]>(
      environment.baseUrl + '/increase-stock/' + id,
      {}
    );
  }
}
