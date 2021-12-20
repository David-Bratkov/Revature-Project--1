import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LandingComponent } from './pages/landing/landing.component';
import { LoginComponent } from './pages/login/login.component';

const routes: Routes = [
  //http://localhost:4200/login
  {path: 'login', component: LoginComponent},
  //http://localhost:4200/dashboard
  {path: 'dashboard', component: DashboardComponent},
  //http://localhost:4200
  {path: '', component: LandingComponent},
  //http://localhost:4200
  {path: '**', component: LandingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
