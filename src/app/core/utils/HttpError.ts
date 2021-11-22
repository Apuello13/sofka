import { HttpErrorResponse } from "@angular/common/http";
import { throwError } from "rxjs";

export function HandleHttpError(error : HttpErrorResponse){
    console.log(error);
    if(error.error){
        return throwError(error.error);
    }else{
        return throwError('Upps, algo ha salido mal :c');
    }
}