import { Component } from '@angular/core';

class Currency{
  id: number;
  name: string;
  value: number;

  constructor(id: number, name: string, value: number) {

    this.id = id;
    this.name = name;
    this.value = value;
  }
}
@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  id: number = 0;
  name: string = "";
  value: number = 0;
  title: string = '';
}
