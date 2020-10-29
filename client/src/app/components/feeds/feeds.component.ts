import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feeds',
  templateUrl: './feeds.component.html',
  styleUrls: ['./feeds.component.css']
})
export class FeedsComponent implements OnInit {
  title = 'client';
 private product: any;

  constructor() {
    console.log('Feeds component is called')
  }

  ngOnInit() {
  }

}
