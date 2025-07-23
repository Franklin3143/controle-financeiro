import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TableModule } from 'primeng/table';
import { Transacao } from '../../../models/transacao.model';
import {CurrencyPipe} from '@angular/common';
import {TransacaoFormComponent} from '../transacao-form/transacao-form.component';

@Component({
  selector: 'app-transacoes-table',
  standalone: true,
  imports: [HttpClientModule, TableModule, CurrencyPipe, TransacaoFormComponent],
  templateUrl: './transacoes-table.component.html',
  styleUrls: ['./transacoes-table.component.scss']
})
export class TransacoesTableComponent implements OnInit {
  transacoes: Transacao[] = [];

  constructor(private http: HttpClient) {}

  carregarTransacoes(): void {
    this.http.get<Transacao[]>('http://localhost:8080/transacoes')
      .subscribe(data => this.transacoes = data);
  }

  ngOnInit(): void {
    this.carregarTransacoes(); // ✅ chamada inicial
  }

}
