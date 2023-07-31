import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent {
  products = ['Külmkapp', 'Pesumasin'];

  constructor(private httpClient: HttpClient) {}

  ngOnInit(): void {
    this.httpClient
      .get<any[]>('http://localhost:8080/products')
      .subscribe((data) => {
        this.products = data.map((product) => product.name);
      });
  }

  addToCart(product: string) {
    this.products = [...this.products, product];
  }
}
