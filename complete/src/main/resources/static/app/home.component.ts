import {Component, OnInit, ElementRef} from '@angular/core';

import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";
import {QuestionService} from "./question.service";


//TODO : refactor this into app---the jQuery material.init() code should only be run once.
declare var jQuery:any;


@Component({
    templateUrl: 'app/home.component.html',
    //providers: [NgModel, NgFormControl]
    providers: [QuestionService]
})
export class HomeComponent implements OnInit {

    form:FormGroup;
    questions: any[];

    constructor(private router:Router,
                private formBuilder: FormBuilder,
                private elementRef:ElementRef ) {
               // private service: QuestionService) {
        //this.questions = service.getQuestions();
    }

    ngOnInit() {
         this.form = this.formBuilder.group({});
    }

    ngAfterContentChecked() {
        // TODO  : move these hacks to a better spot.  common for all application.
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }

    handleSubmit(event:any) {
        this.router.navigate(['/insured']);
    }


}
