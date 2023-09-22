import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ReadMessageRequest} from "../models/read-message";
import {READ_MESSAGE_ENDPOINT} from "../config/api.config";
import {Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReadMessageService {

  constructor(private http: HttpClient) { }

  readMessage(request: ReadMessageRequest): Observable<any> {
    return this.http.post<any>(READ_MESSAGE_ENDPOINT, request).pipe(
        tap(response => {
        })
    );
  }
}
