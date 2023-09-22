import {Component, Input, Output, EventEmitter, ViewChild, ElementRef} from '@angular/core';

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
  @ViewChild('codeElement', { static: false }) codeElement!: ElementRef;
  @ViewChild('contentElement', { static: false }) contentElement!: ElementRef;


  onClose() {
    this.closeModal.emit();
  }

  copyToClipboard(id: string) {
    const textToCopy = id === 'code' ? this.codeElement.nativeElement.textContent : this.contentElement.nativeElement.textContent;
    if (navigator.clipboard) {
      navigator.clipboard.writeText(textToCopy)
          .then(() => {
            console.log('Skopiowano do schowka: ', textToCopy);
          })
          .catch(err => {
            console.error('Błąd kopiowania do schowka: ', err);
          });
    } else {
      console.warn('Twoja przeglądarka nie obsługuje API Clipboard');
    }
  }
}
