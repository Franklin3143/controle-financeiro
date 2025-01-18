import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../services/api.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  displayedColumns: string[] = ['id', 'description', 'value', 'type', 'date'];
  dataSource: any[] = []; // Inicializado como array vazio

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.apiService.getTransactions().subscribe({
      next: (data) => {
        this.dataSource = data; // Recebe os dados do backend
      },
      error: (err) => {
        console.error('Erro ao carregar transações:', err);
      }
    });
  }
}
