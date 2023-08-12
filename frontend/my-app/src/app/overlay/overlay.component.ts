import { Component, Input, Output, EventEmitter } from '@angular/core';

import{Note} from '../models/note';

import { DataService } from '../data.service';

@Component({
  selector: 'app-overlay',
  templateUrl: './overlay.component.html',
  styleUrls: ['./overlay.component.css']
})
export class OverlayComponent {
  @Input() isVisible: boolean = false;
  formData = {
    name: '',
    description: ''
  };

  @Output() hideOverlay = new EventEmitter<void>();

  constructor(private dataService: DataService) {} // Inject DataService

  onCloseClick(): void {
    this.hideOverlay.emit();
  }

  onFormSubmit() {
    // Logic to handle form submission



    // name
    console.log(this.formData.name);
    

    // descr
    console.log(this.formData.description);
    
    const note = new Note(this.formData.name, this.formData.description);

    console.log(note);

      // Send the data to the DataService
      this.dataService.postNote(note).subscribe(
        response => {
          console.log('Post successful:', response);
          // Handle success response
        },
        error => {
          console.error('Error posting data:', error);
          // Handle error response
        }
      );

    // console.log(this.formData);

    // Close the overlay or perform other actions
    this.onCloseClick();
  }



}
