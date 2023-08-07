import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environment/environment';
import { CartProduct } from '../models/cart-product.model';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private paymentUrl = environment.baseUrl + '/orders';
  private parcelMachineUrl = environment.baseUrl + '/parcel-machines';

  constructor(private httpClient: HttpClient) {}

  getPaymentLink(cartProducts: CartProduct[]) {
    return this.httpClient.post(this.paymentUrl + '/1', cartProducts, {
      responseType: 'text',
    });
  }

  getParcelMachines() {
    return this.httpClient.get<any>(this.parcelMachineUrl + '/ee');
  }
}
