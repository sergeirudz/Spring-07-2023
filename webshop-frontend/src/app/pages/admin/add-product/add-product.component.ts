import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Category } from 'src/app/models/category.model';
import { Product } from 'src/app/models/product.model';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss'],
})
export class AddProductComponent {
  categories: Category[] = [];

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data;
    });
  }

  handleSubmit(addProductForm: NgForm) {
    const formValue = addProductForm.value;

    const newProduct = new Product(
      formValue.name,
      formValue.price,
      formValue.image,
      formValue.active,
      formValue.description,
      formValue.stock,
      new Category(formValue.category)
    );

    this.productService.addProduct(newProduct).subscribe((response) => {});
  }
}
