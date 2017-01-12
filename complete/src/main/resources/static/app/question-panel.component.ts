import { Component, Input, OnInit }  from '@angular/core';
import { FormGroup }                 from '@angular/forms';
import { ComponentConfig }           from './component.config';
import { ComponentFactory }    from './componentFactory';
@Component({
    // moduleId: module.id,
    selector: 'question-panel',
    templateUrl: 'app/question-panel.component.html',
    providers: [ ComponentFactory ]
})
export class QuestionPanelComponent implements OnInit {
    @Input() questions: ComponentConfig<any>[] = [];
    form: FormGroup;

    constructor(private qcs: ComponentFactory) {  }

    ngOnInit() {
        this.form = this.qcs.toFormGroup(this.questions);
        // i only need this if i'm the root panel???
        this.form.valueChanges.subscribe(data => console.log('form changes ', data));
    }
}
