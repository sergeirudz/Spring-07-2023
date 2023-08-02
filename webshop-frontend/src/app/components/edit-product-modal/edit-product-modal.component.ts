import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { Product } from 'src/app/models/product.model';

@Component({
  selector: 'app-edit-product-modal',
  templateUrl: './edit-product-modal.component.html',
  styleUrls: ['./edit-product-modal.component.scss'],
})
export class EditProductModalComponent {
  constructor(
    private httpClient: HttpClient,
    public modalRef: MdbModalRef<EditProductModalComponent>
  ) {}

  @Input() product: Product = {} as Product;
  updatedProduct: Product = {} as Product;

  ngOnInit() {
    // Instead of a deep copy, set updatedProduct directly to the product object
    this.updatedProduct = this.product;
  }
  ngOnDestroy() {
    // Perform cleanup tasks if necessary
  }

  updateProduct() {
    console.log('Product updated!', this.updatedProduct);
    // Assuming you have an API endpoint to update the product, make an HTTP call here
    // Replace 'http://localhost:8080/update-product' with your actual API endpoint
    // this.httpClient
    //   .put('http://localhost:8080/update-product', this.updatedProduct)
    //   .subscribe(
    //     (response) => {
    //       // Handle the success response if needed
    //       console.log('Product updated successfully!');
    //       // You can close the modal after successful update
    //       this.modalRef.close();
    //     },
    //     (error) => {
    //       // Handle the error response if needed
    //       console.error('Error updating product:', error);
    //     }
    //   );
  }
}
