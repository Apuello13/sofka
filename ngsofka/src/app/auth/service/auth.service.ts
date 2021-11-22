import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { HandleHttpError } from '../../core/utils/HttpError';

@Injectable()
export class AuthService {
  url : string = `${ environment.apiUrl }/auth`;

  constructor(private http: HttpClient) { }

  login(body : any){
    return this.http.post(`${this.url}/login`, body)
      .pipe(catchError(HandleHttpError));
  }
}
