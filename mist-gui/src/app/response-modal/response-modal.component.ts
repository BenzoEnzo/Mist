import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-response-modal',
  templateUrl: './response-modal.component.html',
  styleUrls: ['./response-modal.component.css']
})
export class ResponseModalComponent {
  @Input() serverResponse: any;
  @Input() isCreateMessageResponse!: Function;
  @Input() isReadMessageResponse!: Function;
  @Output() closeModal = new EventEmitter<void>();

  onClose() {
    this.closeModal.emit();
  }
}
