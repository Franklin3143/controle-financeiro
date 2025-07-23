import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Transacao } from '../../../models/transacao.model';
import {CurrencyPipe} from '@angular/common';
import {TransacaoFormComponent} from '../transacao-form/transacao-form.component';
import {TransacaoService} from '../../../service/transacaoService';
import {ConfirmationService, MessageService} from 'primeng/api';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ToastModule} from 'primeng/toast';

@Component({
  selector: 'app-transacoes-table',
  standalone: true,
  imports: [TableModule, CurrencyPipe, TransacaoFormComponent, ConfirmDialogModule, ToastModule],
  templateUrl: './transacoes-table.component.html',
  styleUrls: ['./transacoes-table.component.scss'],
  providers: [MessageService, ConfirmationService]
})
export class TransacoesTableComponent implements OnInit {
  transacoes: Transacao[] = [];

  constructor(private transacaoService: TransacaoService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService,) {}

  ngOnInit(): void {
    this.carregarTransacoes();
  }

  carregarTransacoes(): void {
    this.transacaoService.listar().subscribe({
      next: (transacoes: Transacao[]) => {
        this.transacoes = transacoes; // ✅ Aqui você armazena os dados recebidos
      },
      error: () => {
        this.messageService.add({
          severity: 'error',
          summary: 'Erro',
          detail: 'Falha ao carregar transações'
        });
      }
    });
  }


  excluirTransacao(id: number): void {
    this.transacaoService.excluir(id).subscribe({
      next: () => {
        this.messageService.add({
          severity: 'success',
          summary: 'Sucesso',
          detail: 'Transação excluída com sucesso',
          life: 3000 });
        this.carregarTransacoes(); // Atualiza a lista após exclusão
      },
      error: () => {
        this.messageService.add({
          severity: 'error',
          summary: 'Erro',
          detail: 'Não foi possível excluir a transação',
          life: 3000 });
      }
    });

  }

  confirmarExclusao(id: number): void {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir esta transação?',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Sim',
      rejectLabel: 'Não',
      accept: () => this.excluirTransacao(id)

    });
  }


}
