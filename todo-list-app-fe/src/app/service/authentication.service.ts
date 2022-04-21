import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { map } from "rxjs/operators";

export class User {
    constructor(public status: string) { }
}

@Injectable({
    providedIn: "root"
})
export class AuthenticationService {
    constructor(private httpClient: HttpClient) { }
    // Provide username and password for authentication, and once authentication is successful, 
    //store JWT token in session
    authenticate(username: string, password: string) {
        console.log(username)
        console.log(password)
        let formData = new FormData();
        formData.append('username', username);
        formData.append('password', password);
        return this.httpClient
            .post<any>("http://localhost:8080/api/login", formData)
            .pipe(
                map(userData => {
                    debugger
                    sessionStorage.setItem("username", username);
                    let tokenStr = "Bearer " + userData.access_token;
                    sessionStorage.setItem("token", tokenStr);
                    return userData;
                })
            );
    }

    isUserLoggedIn() {
        let user = sessionStorage.getItem("username");
        console.log(!(user === null));
        return !(user === null);
    }

    logOut() {
        sessionStorage.removeItem("username");
    }
}