import { Component, OnInit,ViewEncapsulation  } from '@angular/core';
import { DataService } from './data.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  //below allows components to overwight such as margin
  encapsulation: ViewEncapsulation.None,
  // styles
  // styles:['*{ overflow:hidden;}']
})


export class AppComponent implements OnInit {
  notes: any;
  isOverlayVisible: boolean = false; // Add this line
  constructor(private dataService: DataService) { }

  ngOnInit():void {
    this.dataService.getData().subscribe(data => {
      this.notes = data; // Assign the fetched data to the component property
      console.log(data);
    });
  }

  showOverlay() {
    this.isOverlayVisible = true; // Show the overlay
  }

  hideOverlay() {
    this.isOverlayVisible = false; // Hide the overlay
  }
}
