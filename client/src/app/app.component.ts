import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {Injectable} from '@angular/core';
import {User} from "./models/user";
import {AuthService} from "./services/auth.service";

@Injectable({
  providedIn: 'root'
})

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    constructor(private authService: AuthService, private router: Router) {
    }

    title = 'e-Kurban';

    public isAuthenticated = false;
    public currentUser: User | undefined;

    public cikis(): void {
        this.authService.cikis(this.currentUser);
        this.currentUser = undefined;
        this.isAuthenticated = false;
        this.router.navigate(['/giris']);
    }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/