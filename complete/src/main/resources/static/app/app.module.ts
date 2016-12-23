import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutes} from './app.routes';
import {RouterModule} from '@angular/router';

import { AppComponent }  from './app.component';
import { ChatComponent }  from './chat.component';
import { LoginComponent }  from './login.component';
import {CreateAccountComponent} from './createAccount.component';

@NgModule({
    imports:      [ BrowserModule, RouterModule.forRoot(AppRoutes), FormsModule, ReactiveFormsModule ],
    declarations: [ ChatComponent, AppComponent, LoginComponent, CreateAccountComponent ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }

