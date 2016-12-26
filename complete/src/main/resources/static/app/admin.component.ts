import {Component, OnInit, ElementRef} from "@angular/core";
import {FormGroup, FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";
import {Broker} from './broker';
import {RestService} from './rest.service';
import {Observable} from 'rxjs/Observable';

declare var jQuery:any;

@Component({
    selector: 'admin',
    providers: [RestService],
    templateUrl: '/app/admin.component.html'
})
export class AdminComponent implements OnInit {
    form:FormGroup;


    private formConfig:any = {
        'tab':'Brokers'
    };

    public brokers:Observable<Broker[]>;
    // public quotes:Quote[];


    constructor(
        private router: Router,
        private formBuilder:FormBuilder,
       private brokerService: RestService<Broker>,
        private elementRef:ElementRef) {

        this.form = this.formBuilder.group( this.formConfig, { });
        this.brokers = this.brokerService.get();
    }


    ngOnInit() {

    }

    ngAfterContentChecked() {
        jQuery.material.init(); // TODO : refactor this into common component.
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

