import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteService } from '../cliente.service';
import { ModalService } from './modal.service';
import Swal from 'sweetalert2';
import { HttpEvent, HttpEventType } from '@angular/common/http';

type UploadEvent =
  | { status: 'progress', message: number }
  | { status: 'response', responseBody: any }
  | { status: 'error', message: string };

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrl: './detalle.component.css'
})

export class DetalleComponent implements OnInit {
  @Input() cliente: Cliente;
  titulo: string = "Detalle del cliente";
  fotoSelecionada: File;
  progreso: number = 0;

  constructor(private clienteService: ClienteService, public modalService: ModalService) { }

  ngOnInit() { }

  seleccionarFoto(event) {
    this.fotoSelecionada = event.target.files[0];
    this.progreso = 0;
    console.log(this.fotoSelecionada);
    if (this.fotoSelecionada.type.indexOf('image') < 0) {
      Swal.fire('Error seleccionar imagen: ', 'El archivoi debe ser del tipo imagen', 'error');
      this.fotoSelecionada = null;
    }
  }

  subirFoto() {
    if (!this.fotoSelecionada) {
      Swal.fire('Error Upload: ', 'Debe seleccionar una foto', 'error');
    } else {
      this.clienteService.subirFoto(this.fotoSelecionada, this.cliente.id)
        .subscribe(event => {
          if (event.type === HttpEventType.UploadProgress) {
            this.progreso = Math.round((event.loaded / event.total) * 100);
          } else if (event.type === HttpEventType.Response) {
            let response: any = event.body;
            this.cliente = response.cliente as Cliente;
            Swal.fire('La foto se ha subido correctamente!', response.mensaje, 'success');
          }
        }, error => {
          // Manejo de error en caso de fallo en la carga
          Swal.fire('Error de Carga', 'Ha ocurrido un error al subir la foto: ' + error.message, 'error');
        });
    }
  }

  cerrarModal() {
    this.modalService.cerrarModal();
    this.fotoSelecionada = null;
    this.progreso = 0;
  }

}
