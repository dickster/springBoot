
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RestService<T> {

    private actionUrl: string;
    private headers: Headers;

    constructor(public _http: Http ) {
        this.headers = new Headers();
        this.headers.append('Content-Type', 'application/json');
        this.headers.append('Accept', 'application/json');
    }

    public withUrl(url:string) {
        this.actionUrl = url;
        return this;
    }

    public get(): Observable<T[]> {
       return this._http.get(this.actionUrl)
            .map((response: Response) => <T[]>response.json())
            .catch(this.handleError);
    // console.log('hello');
   // return null;
    }


// NOT TESTED YET:
//     public add(toAdd: T): Observable<T> {
//         return this._http.post(this.actionUrl, toAdd, { headers: this.headers })
//             .map((response: Response) => <T>response.json())
//             .catch(this.handleError);
//     }

    private handleError(error: Response) {
        console.error(error);
        return Observable.throw(error.json().error || 'rest service error');
    }
}