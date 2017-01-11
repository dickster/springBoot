import {Component, OnInit, ElementRef} from "@angular/core";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {NgModel, NgFormControl} from "@angular/common";
import {RemoteData, CompleterService} from "ng2-completer";
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Observable';

declare var jQuery:any;


@Component({
    templateUrl: 'app/insured.component.html',
    providers: []
})
export class InsuredComponent implements OnInit {

    form: FormGroup;
    private dataService: RemoteData;

    private searchData = [
        //TODO : turn this into REST service with parameters.  takes segment into account.
        {name: 'Bob', number: '1754'},
        {name: 'Fred', number: '3972'},
        {name: 'Sally', number: '243'},
        {name: 'Cathy', number: '4948'},
        {name: 'Jim', number: '519'},
        {name: 'Sam', number: '6344'},
        {name: 'Susan', number: '9787'}
    ];

    public myCovers =  [
            {name:'Employers Liability'},
            {name:'Directors and Operators'}
        ];

    private formConfig:any = {
        'broker':'Bob',
        'proposal': 'Direct',
        'firstName': ['', Validators.required],
        'middleName': '',
        'segment' : '',
        'lastName': ['', Validators.required],
        'phone': ['']
    };
    private saving:boolean = false;
    private previous : any = {};


    constructor(
        private router: Router,
        private formBuilder: FormBuilder,
        private completerService: CompleterService,
        private http:Http,
        private elementRef:ElementRef) {

        this.dataService = completerService.remote('/broker?search=', '', 'desc');
    }

    ngOnInit() {
        this.formConfig.covers = this.initCovers(this.myCovers);
        this.form = this.formBuilder.group( this.formConfig, {validator:this.isFormValid});
        this.form.valueChanges
            .debounceTime(500)
            .subscribe(data => this.saveDraft(data));
    }

    public saveDraft(data:any) : any {
        if (!this.formChangedSignificantly(data)) {
            return;
        }
        this.saving = true;
        let bodyString = JSON.stringify(data); // Stringify payload
        let headers      = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options       = new RequestOptions({ headers: headers }); // Create a request option

        return this.http.put('/drafts', bodyString, options)
            .map((res:Response) => res.json())
            .subscribe(data => {this.saving = false;},
                (err: any) => {
                    this.saving = false;
                })
    }

    ngAfterContentChecked() {
        // ToDO : put this into common page component.
        // or add jquery.on("document router-outlet").fn(){material.init9)};
        jQuery.material.init();
        jQuery(this.elementRef.nativeElement).find('.completer-input').addClass('form-control');
    }

    isBroker(): boolean {
        return this.form.controls['proposal'].value == 'Broker';
    }

    isDirect(): boolean {
        return this.form.controls['proposal'].value == 'Direct';
    }

    public isCoverEnabled(index) : boolean {
        //noinspection TypeScriptUnresolvedVariable
        return this.form.controls.covers.controls[index].controls.name.value;
    }

    public anyCovers() : boolean {
        //noinspection TypeScriptUnresolvedVariable
        for (let i in this.form.controls.covers.controls) {
            if (this.isCoverEnabled(i)) return true;
        }
        return false;
    }

    private initCovers(covers) {
        let result = [];
        for (let cover of covers) {
            result.push(this.newCover());
        }
        return this.formBuilder.array(result);
    }

    private newCover() {
        return this.formBuilder.group({
            name: [false],
            commission: ['']
        });
    }

    // isValidTotalCommission(form) : any {
    // }

    isFormValid(form):any {
//        if (form.controls.proposal.value=='Broker' && !form.controls.broker.value) {
//            return {msg:'no broker specified', field:'broker'};
//        }
        let result:number = 0;
        let pristine:boolean = true;
        for (let cover of form.controls.covers.controls) {
            let commission = cover.controls.commission;
            pristine = (commission.pristine) && pristine;
            result += commission.value;
        }
        let valid : boolean = (result == 100 || pristine);
        return (valid) ? null :
            { msg: "commission must total 100, currently (" + result + ")", field: 'commission'};
    }


    handleSubmit(event) {
        console.log(this.form.value);
        event.preventDefault();
        this.router.navigate(['/chat']);
    }

    private formChangedSignificantly(data: any) {
        let result:boolean = this.previous.segment!=data.segment || this.previous.proposal!=data.proposal;
        this.previous = Object.assign({}, data);
        return result;
    }

    public isSaving():boolean {
        return this.saving;
    }
}
