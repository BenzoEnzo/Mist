import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CREATE_MESSAGE_ENDPOINT } from "../config/api.config";
import {CreateMessageRequest} from "../models/create-message.request";
import {CreateMessageResponse} from "../models/create-message.response";
import {tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CreateMessageService {

  constructor(private http: HttpClient) { }

  // @ts-ignore
  createMessage(request: CreateMessageRequest): Observable<CreateMessageResponse> {

    console.log("Sending request to:", CREATE_MESSAGE_ENDPOINT);
    console.log("Request body:", request);

    return this.http.post<CreateMessageResponse>(CREATE_MESSAGE_ENDPOINT, request).pipe(
      tap(response => {
        console.log("Received response:", response);
      })
    );
  }
}
