import { NgModule } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { SharedModule } from '../shared/shared.module';
import { UsersComponent } from './users/users.component';

@NgModule({
  declarations: [
    HomeComponent,
    NotFoundComponent,
    UsersComponent
  ],
  imports: [
    SharedModule
  ]
})
export class CoreModule { }
