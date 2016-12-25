import {Directive, Input, ElementRef, Component} from '@angular/core';
import { CompleterService, CompleterData } from 'ng2-completer';
import {COMMON_DIRECTIVES, FORM_DIRECTIVES} from '@angular2/common';

@Component(
    {   selector: 'autocomplete',
        directives: [COMMON_DIRECTIVES,FORM_DIRECTIVES],
        template: '<ng2-completer [(ngModel)]="searchStr" [dataService]="dataService" [minSearchLength]="0"></ng2-completer>'
    })
export class AutoComplete {

    private searchStr: string;
    private dataService: CompleterData;
    private searchData = [
        { color: 'red', value: '#f00' },
        { color: 'green', value: '#0f0' },
        { color: 'blue', value: '#00f' },
        { color: 'cyan', value: '#0ff' },
        { color: 'magenta', value: '#f0f' },
        { color: 'yellow', value: '#ff0' },
        { color: 'black', value: '#000' }
    ];

    constructor(private completerService: CompleterService) {
        this.dataService = completerService.local(this.searchData, 'color', 'color');
    }

}
