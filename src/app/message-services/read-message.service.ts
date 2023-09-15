
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {catchError, Observable, of, tap} from 'rxjs';
import {ReadMessageRequest} from "../models/read-message.request";
import {READ_MESSAGE_ENDPOINT} from "../config/api.config";

@Injectable({
  providedIn: 'root'
})
export class ReadMessageService {

  constructor(private http: HttpClient) { }

  readMessage(request: ReadMessageRequest): Observable<any> {
    return this.http.post<any>(READ_MESSAGE_ENDPOINT, request)
      .pipe(
        tap(response => {
          console.log('Received response:', response);
        }),
        catchError(err => {
          console.error('An error occurred:', err);
          return of(null);  // return an Observable which emits "null" as a fallback
        })
      );
  }
}
