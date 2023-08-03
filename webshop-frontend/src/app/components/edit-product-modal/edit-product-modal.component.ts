import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { Category } from 'src/app/models/category.model';
import { Product } from 'src/app/models/product.model';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-edit-product-modal',
  templateUrl: './edit-product-modal.component.html',
  styleUrls: ['./edit-product-modal.component.scss'],
})
export class EditProductModalComponent {
  @Input() product!: Product;
  updatedProduct: Product = {} as Product;
  categories: Category[] = [];
  editProductForm!: FormGroup;

  constructor(
    private productService: ProductService,
    private categoryService: CategoryService,
    public modalRef: MdbModalRef<EditProductModalComponent>
  ) {}

  ngOnInit() {
    // Instead of a deep copy, set updatedProduct directly to the product object
    this.updatedProduct = this.product;
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data;
    });
    console.log(this.product);

    this.productService.getProduct(this.product).subscribe((data) => {
      this.editProductForm = new FormGroup({
        name: new FormControl(this.product.name),
        description: new FormControl(this.product.description),
        price: new FormControl(this.product.price),
        stock: new FormControl(this.product.stock),
        image: new FormControl(this.product.image),
        active: new FormControl(this.product.active),
        category: new FormControl(this.product.category),
      });
    });
  }
  ngOnDestroy() {
    // Perform cleanup tasks if necessary
  }

  updateProduct() {
    console.log('Product updated!', this.updatedProduct);

    this.productService
      .editProduct(this.updatedProduct)
      .subscribe((response) => {});
  }
}
