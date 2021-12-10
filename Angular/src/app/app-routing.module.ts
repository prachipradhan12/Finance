import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivateUserComponent } from './activate-user/activate-user.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { Adminlogin } from './adminlogin';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ErrorComponent } from './error/error.component';
import { ForgotpasswordComponent } from './forgotpassword/forgotpassword.component';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { ProductdetailsComponent } from './productdetails/productdetails.component';
import { ProductsComponent } from './products/products.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'indexLink',
    pathMatch: 'full',
  },
  {
    path: 'indexLink',
    component: IndexComponent,
  },
  {
    path: 'registerLink',
    component: RegisterComponent,
  },
  {
    path: 'loginLink',
    component: LoginComponent,
  },
  {
    path: 'changepassLink',
    component: ChangepasswordComponent,
  },
  {
    path: 'forgotpassLink',
    component: ForgotpasswordComponent,
  },
  {path:'products',component:ProductsComponent},
  {path:'productdetails',component:ProductdetailsComponent},
  {path:'userdashboard',component:DashboardComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'admindashboard',component:AdminpageComponent},
  {path:'addproducts',component:AddproductComponent},
  {path:'showallcards',component:ActivateUserComponent  },
  {path:'**',component:ErrorComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
