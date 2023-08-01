import { Component } from '@angular/core';
import { Product } from 'src/app/models/product.model';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss'],
})
export class AddProductComponent {
  product: Product = {} as Product;

  handleSubmit() {
    console.log('Form submitted!');
    console.log('Product Name:', this.product.name);
    console.log('Product Description:', this.product.description);
    console.log('Product Image:', this.product.image);
    console.log('Product Price:', this.product.price);
    console.log('Product Category:', this.product.category);
    console.log('Product Quantity:', this.product.stock);
    console.log('Product Active:', this.product.active);
  }
}
