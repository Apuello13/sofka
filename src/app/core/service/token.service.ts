import { Injectable } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class TokenService{

    saveToken(body : any){
        localStorage.setItem("user", JSON.stringify(body));
    }

    getUser(){
        return JSON.parse(localStorage.getItem('user'));
    }
}