
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
import { Observable } from 'rxjs/Observable';
import {Broker} from './broker';

@Injectable()
export class RestService<T> {

    private actionUrl: string;
    private headers: Headers;

    constructor(private _http: Http ) {

        this.actionUrl = '/broker/all';
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }

    public get(): Observable<Broker[]> {
       return this._http.get(this.actionUrl)
            .map((response: Response) => <T[]>response.json())
            .catch(this.handleError);
    // console.log('hello');
   // return null;
    }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'rest service error');
    }
}