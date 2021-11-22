import { Component, OnInit } from '@angular/core';
import { TokenService } from '../service/token.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  greeting : string = "Hola";
  constructor(
    private _user : UserService,
    private _token : TokenService
  ) { }

  ngOnInit(): void {
    this.getGreeting();
  }

  getGreeting(){
    const idUser = this._token.getUser().id;
    this._user.getGreeting(idUser)
      .subscribe((response) => {
        this.greeting = response.greeting;
      }, badRequest => {
        alert(badRequest);
      })
  }
}
