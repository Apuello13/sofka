import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html'
})
export class UsersComponent implements OnInit {
  usuarios : User[] = [];
  constructor(
    private _user : UserService
  ) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this._user.getUsers()
      .subscribe(response => {
        this.usuarios = response;
      }, badRequest => {
        alert(badRequest);
      })
  }

}
