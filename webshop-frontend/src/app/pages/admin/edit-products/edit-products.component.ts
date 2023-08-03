import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { Observable } from 'rxjs';
import { EditProductModalComponent } from 'src/app/components/edit-product-modal/edit-product-modal.component';
import { Category } from 'src/app/models/category.model';
import { Product } from 'src/app/models/product.model';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-edit-products',
  templateUrl: './edit-products.component.html',
  styleUrls: ['./edit-products.component.scss'],
})
export class EditProductsComponent {
  modalRef: MdbModalRef<EditProductModalComponent> | null = null;
  products: Product[] = [];

  categories: Category[] = [];

  constructor(
    private categoryService: CategoryService,
    private productService: ProductService,
    private modalService: MdbModalService
  ) {}

  ngOnInit(): void {
    this.categoryService.getCategories().subscribe((data) => {
      this.categories = data;
    });

    this.productService.getProducts().subscribe((data) => {
      this.products = data;
    });
  }

  /* handleSubmit(addProductForm: NgForm) {
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
  } */

  handleDeleteProduct(product: Product) {
    this.productService.deleteProduct(product).subscribe((response) => {});
  }

  openModal(product: Product) {
    this.modalRef = this.modalService.open(EditProductModalComponent, {
      data: {
        product: product,
      },
    });
  }
}
