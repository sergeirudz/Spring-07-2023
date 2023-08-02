import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { EditProductModalComponent } from 'src/app/components/edit-product-modal/edit-product-modal.component';
import { Product } from 'src/app/models/product.model';

@Component({
  selector: 'app-edit-products',
  templateUrl: './edit-products.component.html',
  styleUrls: ['./edit-products.component.scss'],
})
export class EditProductsComponent {
  modalRef: MdbModalRef<EditProductModalComponent> | null = null;
  products: Product[] = [];

  constructor(
    private httpClient: HttpClient,
    private modalService: MdbModalService
  ) {}

  ngOnInit() {
    this.httpClient
      .get<Product[]>('http://localhost:8080/products')
      .subscribe((data) => {
        this.products = data;
      });
  }

  openModal(product: Product) {
    this.modalRef = this.modalService.open(EditProductModalComponent);
  }
}
