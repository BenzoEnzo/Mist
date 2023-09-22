import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CreateMessageService} from '../message-services/create-message.service';
import {ReadMessageService} from "../message-services/read-message.service";
import 'bootstrap';
import {ReadMessageRequest} from "../models/read-message.request";
import {CreateMessageRequest} from "../models/create-message.request";
import {tap} from "rxjs";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  messageForm: FormGroup;
  selectedAction: string = 'read';
  serverResponse: any;
  showModal: boolean = false;

  constructor(
    private fb: FormBuilder,
    private readMessageService: ReadMessageService,
    private createMessageService: CreateMessageService
  ) {
    this.messageForm = this.fb.group({
      action: [this.selectedAction],
      messageId: [''],
      messageContent: [''],
      messageExpiry: ['']
    });
  }

  ngOnInit(): void { }

  onActionChange() {
    this.selectedAction = this.messageForm.get('action')?.value;
    console.log('Selected action:', this.selectedAction);
  }

  onSubmit() {
    if (this.selectedAction === 'read') {
      const request: ReadMessageRequest = { id: this.messageForm.value.messageId };
      this.readMessageService.readMessage(request).subscribe(response => {
        console.log('Received response:', response);
        this.serverResponse = response;
        this.showModal = true;
      });
    } else if (this.selectedAction === 'send') {
      const request: CreateMessageRequest = {
        content: this.messageForm.value.messageContent,
        deleteAfterTime: this.messageForm.value.messageExpiry
      };
      this.createMessageService.createMessage(request).pipe(tap(response => {
        console.log('Received response:', response);
        this.serverResponse = response;
        this.showModal = true;
      })).subscribe();
    }
  }

  closeModal() {
    this.showModal = false;
  }
  isCreateMessageResponse(response: any): boolean {
    return response.hasOwnProperty('id');
  }

  isReadMessageResponse(response: any): boolean {
    return response.hasOwnProperty('content');
  }
}
