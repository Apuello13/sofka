import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { AuthService } from './service/auth.service';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    SharedModule
  ],
  providers: [
    AuthService
  ]
})
export class AuthModule { }
