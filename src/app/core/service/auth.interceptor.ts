import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { NgxSpinnerService } from "ngx-spinner";
import { Observable } from "rxjs";
import { finalize } from 'rxjs/operators';
import { TokenService } from "./token.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{
    constructor(
        private _spinner : NgxSpinnerService,
        private _token : TokenService
    ){}

    intercept(request: HttpRequest<any>, next: HttpHandler) : Observable<HttpEvent<any>>{
        this._spinner.show();
        request = request.clone({
            setHeaders: {
                Authorization: this.getToken()
            }
        })
        return next.handle(request).pipe(
            finalize(() => {
                this._spinner.hide();
            })
        )
    }

    getToken() : string{
        if(this._token.getUser()){
            return 'Bearer ' + this._token.getUser().token;
        }
        return "";
    }
}