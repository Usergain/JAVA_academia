import { Injectable } from '@angular/core';
import { formatDate, DatePipe } from '@angular/common';

import { CLIENTES } from './clientes.json';
import { Cliente } from './cliente';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { map, catchError, tap } from 'rxjs';
import swal from 'sweetalert2';
import { Router } from '@angular/router';
import { PaginatedResponse } from '../paginator/paginated-response.interface';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private urlEndPoint: string = 'http://localhost:8080/api/clientes';

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' })

  constructor(private http: HttpClient, private router: Router) { }

  /*getClientes(): Observable<Cliente[]> {
    //return of(CLIENTES); //observable
    return this.http.get<Cliente[]>(this.urlEndPoint);
  }*/

  getClientes(page: number = 0): Observable<PaginatedResponse<Cliente>> {
    const urlClient = `${this.urlEndPoint}/page/${page}`;
    return this.http.get<PaginatedResponse<Cliente>>(urlClient).pipe(
      //map((response: any) => response.content as Cliente[])
    );
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.http.post(this.urlEndPoint, cliente, { headers: this.httpHeaders }).pipe(
      map((response: any) => response.cliente as Cliente),
      catchError(e => {

        if (e.status == 400) {
          return throwError(() => e);
        }

        console.error(e.error.mensaje);
        swal.fire('error al crear al cliente', e.error.mensaje, 'error');
        return throwError(() => e);
      })
    )
  }

  getCliente(id: any): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/clientes']);
        console.error(e.error.mensaje);
        swal.fire('error al editar', e.error.mensaje, 'error');
        return throwError(() => e);
      })
    );
  }

  update(cliente: Cliente): Observable<any> {
    return this.http.put<any>(`${this.urlEndPoint}/${cliente.id}`, cliente, { headers: this.httpHeaders }).pipe(
      catchError(e => {

        if (e.status == 400) {
          return throwError(() => e);
        }

        console.error(e.error.mensaje);
        swal.fire('error al editar al cliente', e.error.mensaje, 'error');
        return throwError(() => e);
      })
    )
  }

  delete(id: number): Observable<Cliente> {
    return this.http.delete<Cliente>(`${this.urlEndPoint}/${id}`, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire('error al eliminar al cliente', e.error.mensaje, 'error');
        return throwError(() => e);
      })
    )
  }

  subirFoto(archivo: File, id): Observable<HttpEvent<{}>> {
    let formData = new FormData;
    formData.append("archivo", archivo);
    formData.append("id", id);

    const req = new HttpRequest('POST', `${this.urlEndPoint}/upload`, formData, {
      reportProgress: true,
    });

    return this.http.request(req);

  }
}