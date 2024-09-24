//src/app/paginator/paginated-response.interface.ts

export interface PaginatedResponse<T> {
    content: T[];
    totalPages: number;
    // ... otras propiedades de paginación como totalElements, size, number, etc.
  }
  