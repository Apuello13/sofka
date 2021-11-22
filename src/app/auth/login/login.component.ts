import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/core/service/token.service';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;
  constructor(
    private formBuilder : FormBuilder,
    private _auth : AuthService,
    private router : Router,
    private _token : TokenService
  ) { 
    this.loginForm = this.formBuilder.group({
      username : ['', Validators.required],
      password : ['', Validators.required]
    })
  }

  login(){
    this._auth.login(this.loginForm.value)
      .subscribe((response : any) => {
        this._token.saveToken(response);
        this.router.navigateByUrl("/home");
      }, badRequest => {
        alert(badRequest);
      })
  }

}
