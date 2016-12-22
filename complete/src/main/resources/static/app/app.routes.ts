import {ChatComponent} from "./chat.component";


export const AppRoutes:Routes = [
    { path: '', component: ChatComponent },
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

