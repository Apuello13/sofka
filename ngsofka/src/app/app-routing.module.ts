import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { UserGuard } from './core/guards/user.guard';
import { HomeComponent } from './core/home/home.component';
import { NotFoundComponent } from './core/not-found/not-found.component';
import { UsersComponent } from './core/users/users.component';

const routes: Routes = [
  { 
    path: 'home', 
    component: HomeComponent,
    canActivate: [UserGuard]
  },
  { path: 'login', component: LoginComponent },
  { 
    path: 'users', 
    component: UsersComponent,
    canActivate: [UserGuard]
  },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
