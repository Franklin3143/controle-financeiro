import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root' // Garante que o serviço estará disponível em toda a aplicação
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api'; // URL base do backend

  constructor(private http: HttpClient) {}

  /**
   * Obtém a lista de transações do backend.
   * @returns Observable com os dados das transações
   */
  getTransactions(): Observable<any[]> {
    const endpoint = `${this.baseUrl}/transactions`;
    return this.http.get<any[]>(endpoint).pipe(
      catchError(this.handleError)
    );
  }

  /**
   * Manipula erros da API.
   * @param error O erro recebido da requisição HTTP
   * @returns Um erro formatado
   */
  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      // Erros no lado do cliente
      console.error('Erro no lado do cliente:', error.error.message);
    } else {
      // Erros no lado do servidor
      console.error(
        `Erro do servidor: ${error.status}, ` +
        `Mensagem: ${error.message}`
      );
    }
    // Retorna um erro legível para o usuário
    return throwError('Ocorreu um erro ao se comunicar com o servidor. Tente novamente mais tarde.');
  }
}
