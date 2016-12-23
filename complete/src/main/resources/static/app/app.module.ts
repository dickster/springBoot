import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutes} from './app.routes';
import {RouterModule} from '@angular/router';

import { AppComponent }  from './app.component';
import { InsuredComponent }  from './insured.component';
import { ChatComponent }  from './chat.component';
import { LoginComponent }  from './login.component';
import {CreateAccountComponent} from './createAccount.component';
import {InsuredComponent} from './insured.component';

@NgModule({
    imports:      [ BrowserModule, RouterModule.forRoot(AppRoutes), FormsModule, ReactiveFormsModule ],
    declarations: [ ChatComponent, InsuredComponent, AppComponent, LoginComponent, CreateAccountComponent ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }

