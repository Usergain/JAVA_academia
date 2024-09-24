import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Bienvenido a Angular';

  curso: string = 'Curso Spring con Angular';
  profesor: string = 'Arkaitz Artaraz'
}
