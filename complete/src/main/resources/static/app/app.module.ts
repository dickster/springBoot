import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { ChatComponent }  from './chat.component';
import { AppComponent }  from './app.component';
import { LoginComponent }  from './login.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutes} from './app.routes';
import {RouterModule} from '@angular/router';

@NgModule({
    imports:      [ BrowserModule, RouterModule.forRoot(AppRoutes), FormsModule, ReactiveFormsModule ],
    declarations: [ ChatComponent, AppComponent, LoginComponent ],
    bootstrap:    [ AppComponent ]
})
export class AppModule { }

