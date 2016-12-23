import {ChatComponent} from "./chat.component";
import {LoginComponent} from "./login.component";
import {CreateAccountComponent} from "./createAccount.component";
import {InsuredComponent} from "./insured.component";


export const AppRoutes:Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'create', component: CreateAccountComponent },
    { path: 'insured', component: InsuredComponent },
];

