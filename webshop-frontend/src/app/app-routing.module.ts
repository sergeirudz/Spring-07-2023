import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { CartComponent } from './pages/cart/cart.component';
import { EditProductComponent } from './pages/admin/edit-product/edit-product.component';
import { MaintainProductsComponent } from './pages/admin/maintain-products/maintain-products.component';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'ostukorv', component: CartComponent },
  { path: 'lisa-toode', component: AddProductComponent },
  { path: 'muuda-toode', component: EditProductComponent },
  { path: 'halda-tooteid', component: MaintainProductsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
