import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { CartComponent } from './pages/cart/cart.component';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';
import { EditProductsComponent } from './pages/admin/edit-products/edit-products.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'cart', component: CartComponent },
  { path: 'add-product', component: AddProductComponent },
  { path: 'edit-products', component: EditProductsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
