import {Component, OnInit, ElementRef} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";
import {CompleterData, CompleterService} from "ng2-completer";

declare var jQuery:any;

@Component({
    templateUrl: 'app/payment.component.html'
})
export class PaymentComponent implements OnInit {

    form: FormGroup;
    total: number = 345.00;

    private formConfig:any = {
        'creditCard':['',Validators.required],
        'paymentDate': '1',
        'securityCode': ['', Validators.required]
    };


    handleSubmit(event:any) {
        event.preventDefault();
        this.router.navigate(['/review']);
    }

    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private elementRef:ElementRef) {
    }

    ngOnInit() {
        this.form = this.formBuilder.group( this.formConfig );
    }

    ngAfterContentChecked() {
        // refactor this into utils.
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }


}
