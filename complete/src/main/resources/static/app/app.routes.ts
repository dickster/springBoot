import {ChatComponent} from "./chat.component";
import {LoginComponent} from "./login.component";
import {CreateAccountComponent} from "./createAccount.component";
import {InsuredComponent} from "./insured.component";
import {AdminComponent} from "./admin.component";

import {Routes} from "@angular/router";
import {HomeComponent} from "./home.component";


export const AppRoutes:Routes = [
    { path: '', component: LoginComponent },
    { path: 'admin', component: AdminComponent },
    { path: 'ai', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'create', component: CreateAccountComponent },
    { path: 'insured', component: InsuredComponent },
    { path: 'chat', component: ChatComponent }

];

