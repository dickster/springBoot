import { Component } from '@angular/core';
import {Component, OnInit, ElementRef} from "@angular/core";
import {FormGroup, FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";

declare var jQuery:any;

@Component({
    selector: 'admin',
    templateUrl: '/app/admin.component.html'
})
export class AdminComponent implements OnInit {
    form:FormGroup;


    private formConfig:any = {
        'tab':'Bob'
    };

    constructor(
        private router: Router,
        private formBuilder:FormBuilder,
        private elementRef:ElementRef) {

        this.form = this.formBuilder.group( this.formConfig, {

        });
    }


    ngOnInit() {
    }

    ngAfterContentChecked() {
        jQuery.material.init();
    }

    isBrokers(): boolean {
        return this.form.controls['tab'].value == 'brokers';
    }

    isMessages(): boolean {
        return this.form.controls['tab'].value == 'messages';
    }


    isQuotes(): boolean {
        return this.form.controls['tab'].value == 'quotes';
    }

    isForms(): boolean {
        return this.form.controls['tab'].value == 'forms';
    }
}

