import { Component, OnInit } from '@angular/core';

@Component({
  // Selectores deben tener al menos 1 guión '-'
  // para no confundir con etiquetas HTML
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
