import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Greeting } from '../models/greeting';
import { User } from '../models/user';
import { HandleHttpError } from '../utils/HttpError';

@Injectable({
  providedIn: 'root'
})
export class UserService{
  url : string = `${ environment.apiUrl }/user`;
  constructor(private http : HttpClient) { }

  getGreeting(idUsuario : string){
    return this.http.get<Greeting>(`${this.url}/greet/${idUsuario}`)
      .pipe(catchError(HandleHttpError));
  }

  getUsers(){
    return this.http.get<User[]>(`${this.url}/list`)
      .pipe(catchError(HandleHttpError));
  }

}
