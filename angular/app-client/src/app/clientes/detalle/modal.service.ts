import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  modal: boolean = false;

  constructor() {}

  public abrirModal() {
    this.modal = true;
  }

  public cerrarModal() {
    this.modal = false;
  }
}
