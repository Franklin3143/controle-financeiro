import { Component, OnInit } from '@angular/core';
import { TableModule } from 'primeng/table';
import { Transacao } from '../../../models/transacao.model';
import {CommonModule, CurrencyPipe} from '@angular/common';
import {TransacaoFormComponent} from '../transacao-form/transacao-form.component';
import {TransacaoService} from '../../../service/transacaoService';
import {ConfirmationService, MessageService} from 'primeng/api';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ToastModule} from 'primeng/toast';
import {ButtonDirective} from 'primeng/button';
import {TransacaoEdicaoFormComponent} from '../transacao-edicao-form/transacao-edicao-form.component';

@Component({
  selector: 'app-transacoes-table',
  standalone: true,
  imports: [TableModule, CurrencyPipe, TransacaoFormComponent, ConfirmDialogModule, ToastModule, ButtonDirective, TransacaoEdicaoFormComponent, CommonModule],
  templateUrl: './transacoes-table.component.html',
  styleUrls: ['./transacoes-table.component.scss'],
  providers: [MessageService, ConfirmationService]
})
export class TransacoesTableComponent implements OnInit {
  transacoes: Transacao[] = [];
  transacaoSelecionadaId?: number;
  mostrarFormulario = false;


  constructor(private transacaoService: TransacaoService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService,) {}

  ngOnInit(): void {
    this.carregarTransacoes();
  }

  carregarTransacoes(): void {
    this.transacaoService.listar().subscribe({
      next: (transacoes: Transacao[]) => {
        this.transacoes = transacoes;
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
        this.carregarTransacoes();
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

  editarTransacao(id: number): void {
    this.transacaoSelecionadaId = id;
    this.mostrarFormulario = true;
  }

  atualizacaoConcluida(): void {
    this.mostrarFormulario = false;
    this.carregarTransacoes(); // ou qualquer método que atualize a tabela
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
