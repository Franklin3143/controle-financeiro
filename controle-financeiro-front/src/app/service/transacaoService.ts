import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Transacao} from '../models/transacao.model';

@Injectable({
  providedIn: 'root'
})
export class TransacaoService {
  private apiUrl = 'http://localhost:8080'; // 🔁 Altere para o seu endpoint real

  constructor(private http: HttpClient) {}

  // 🔄 Buscar todas as transações
  listar(): Observable<Transacao[]> {
    return this.http.get<Transacao[]>(`${this.apiUrl}/transacoes`);
  }

  // 💾 Salvar nova transação
  salvar(transacao: Transacao): Observable<Transacao> {
    return this.http.post<Transacao>(`${this.apiUrl}/transacoes`, transacao);
  }

  // 🗑️ Excluir transação por ID
  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/transacoes/${id}`);
  }

  // ✏️ Atualizar transação (opcional)
  atualizar(transacao: Transacao): Observable<Transacao> {
    return this.http.put<Transacao>(`${this.apiUrl}/transacoes/${transacao.id}`, transacao);
  }
}
