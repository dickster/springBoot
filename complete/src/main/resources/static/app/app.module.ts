import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutes} from './app.routes';
import {RouterModule} from '@angular/router';
import {Ng2CompleterModule} from "ng2-completer";

import { AppComponent }  from './app.component';
import { InsuredComponent }  from './insured.component';
import { ChatComponent }  from './chat.component';
import { LoginComponent }  from './login.component';
import {CreateAccountComponent} from './createAccount.component';
import {AdminComponent} from './admin.component';
import {RestService} from './rest.service';
import { HttpModule } from '@angular/http';
import {Broker} from './broker';



@NgModule({
    imports:      [ HttpModule, BrowserModule,  Ng2CompleterModule, RouterModule.forRoot(AppRoutes), FormsModule, ReactiveFormsModule ],
//    imports:      [ BrowserModule, Ng2CompleterModule, RouterModule.forRoot(AppRoutes), FormsModule, ReactiveFormsModule ],
    declarations: [ AdminComponent, ChatComponent, InsuredComponent, AppComponent, LoginComponent, CreateAccountComponent ],
    providers: [RestService],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }

