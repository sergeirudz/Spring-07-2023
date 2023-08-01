import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { Product } from 'src/app/models/product.model';

@Component({
  selector: 'app-edit-product-modal',
  templateUrl: './edit-product-modal.component.html',
  styleUrls: ['./edit-product-modal.component.scss'],
})
export class EditProductModalComponent {
  constructor(public modalRef: MdbModalRef<EditProductModalComponent>) {}

  @Input() product: Product = {} as Product;
}
