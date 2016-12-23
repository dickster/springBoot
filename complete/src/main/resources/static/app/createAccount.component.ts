import {Component, OnInit} from '@angular/core';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {ControlGroup, NgModel, NgFormControl} from "@angular/common";

@Component({
    selector:'createAccount-comp',
    templateUrl: 'app/createAccount.component.html',
    providers: []
})
export class CreateAccountComponent implements OnInit {

    form:FormGroup;

    constructor(private router:Router, private formBuilder: FormBuilder) { }

    ngOnInit() {

         this.form = this.formBuilder.group({
             }
         );
    }

    handleSubmit(event) {
        // console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/chat']);
    }


}
