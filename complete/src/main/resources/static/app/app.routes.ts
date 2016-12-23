import {ChatComponent} from "./chat.component";
import {LoginComponent} from "./login.component";


export const AppRoutes:Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: ChatComponent },
    { path: 'chat', component: ChatComponent }

//    { path: 'login', component: LoginComponent },  // not needed..redundant???
//    { path: 'login', component: LoginComponent },  // not needed..redundant???
//    { path: 'home', component: HomeComponent },
//    { path: 'insured', component: InsuredComponent},
//    { path: 'location', component: LocationComponent },
//    { path: 'payment', component: PaymentComponent },
//    { path: 'review', component: ReviewComponent },
//    { path: 'createAccount', component: CreateAccountComponent },
];

