import { Routes } from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {TransacoesTableComponent} from './pages/transacoes/transacoes-table/transacoes-table.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'dashboard', component: HomeComponent },
  { path: 'relatorios/transacoes', component: TransacoesTableComponent }
];

