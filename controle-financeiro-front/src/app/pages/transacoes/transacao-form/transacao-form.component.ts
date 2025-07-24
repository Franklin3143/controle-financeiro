import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { CalendarModule } from 'primeng/calendar';
import { ButtonModule } from 'primeng/button';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {Categoria} from '../../../models/categoria.model';
import {Usuario} from '../../../models/usuario.model';



@Component({
  selector: 'app-transacao-form',
  standalone: true,
  imports: [
    DialogModule,
    InputTextModule,
    DropdownModule,
    CalendarModule,
    ButtonModule,
    FormsModule
  ],
  templateUrl: './transacao-form.component.html',
  styleUrls: ['./transacao-form.component.scss']
})
export class TransacaoFormComponent implements OnInit {
  @Output() transacaoSalva = new EventEmitter();
  visible = false;

  descricao = '';
  valor = 0;
  data: Date | null = null;
  tipo = 'RECEITA';

  categorias: Categoria[] = [];
  usuarios: Usuario[] = [];

  categoriaSelecionada: Categoria | null = null;
  usuarioSelecionado: Usuario | null = null;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Categoria[]>('http://localhost:8080/categorias')
      .subscribe(data => {
        this.categorias = data
      });

    this.http.get<Usuario[]>('http://localhost:8080/usuarios')
      .subscribe(data => {
        this.usuarios = data
      });
  }

  abrirDialog() {
    this.visible = true;
  }

  salvar() {
    const body = {
      descricao: this.descricao,
      valor: this.valor,
      data: this.data?.toISOString().split('T')[0],
      tipo: this.tipo,
      categoriaId: this.categoriaSelecionada?.id,
      usuarioId: this.usuarioSelecionado?.id
    };

    this.http.post('http://localhost:8080/transacoes', body)
      .subscribe(() => {
        this.visible = false;
        this.transacaoSalva.emit('ok');
        this.resetForm();
      });
  }

  resetForm(): void {
    this.descricao = '';
    this.valor = 0;
    this.data = null;
    this.tipo = 'RECEITA';
    this.categoriaSelecionada = null;
    this.usuarioSelecionado = null;
  }

}
