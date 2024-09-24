import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { ModalService } from './detalle/modal.service';
import swal from 'sweetalert2'
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
})
export class ClientesComponent implements OnInit {

  clientes!: Cliente[];
  paginador: any;
  clienteSeleccionado: Cliente;

  constructor(private clienteService: ClienteService,
    public modalService: ModalService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      // Utiliza el operador de aserción no nula (!)
      let page: number = +params.get('page')! | 0;

      if (isNaN(page) || page < 0) {
        page = 0;
      }

      this.clienteService.getClientes(page).subscribe(response => {
        this.clientes = response.content;
        // Y ahora también puedes acceder a las propiedades de paginación:
        this.paginador = {
          totalPages: response.totalPages,
          number: page,
          first: page === 0,
          last: page === response.totalPages - 1
        };
      });

    });
  }

  delete(cliente: Cliente): void {
    const swalWithBootstrapButtons = swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger"
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: `¿Estas seguro?`,
      text: `¿Seguro que desea eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: `Si, eliminar`,
      cancelButtonText: `No, cancelar!`,
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        this.clientes = this.clientes.filter(cli => cli !== cliente)
        swalWithBootstrapButtons.fire({
          title: `Cliente Eliminado`,
          text: `Cliente ${cliente.nombre} eliminado con éxito.`,
          icon: "success"
        });
      }
    });
  }

  abrirModal(cliente: Cliente) {
    this.clienteSeleccionado = cliente;
    this.modalService.abrirModal();
  }

}
