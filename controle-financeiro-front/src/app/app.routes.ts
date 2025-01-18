import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {TransactionComponent} from './componente/transaction/transaction.component';

const routes: Routes = [
  { path: 'transactions', component: TransactionComponent },
  { path: '', redirectTo: '/transactions', pathMatch: 'full' } // Redireciona para transactions por padrão
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
