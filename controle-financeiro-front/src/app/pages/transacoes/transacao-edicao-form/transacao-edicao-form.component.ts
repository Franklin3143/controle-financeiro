import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {TransacaoService} from '../../../service/transacaoService';
import {Panel} from 'primeng/panel';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-transacao-edicao-form',
  templateUrl: './transacao-edicao-form.component.html',
  standalone: true,
  imports: [
    Panel,
    ReactiveFormsModule,
    CommonModule
  ],
  styleUrl: './transacao-edicao-form.component.scss'
})
export class TransacaoEdicaoFormComponent implements OnInit{
  @Input() transacaoId!: number;
  @Output() aoAtualizar = new EventEmitter<void>();

  form!: FormGroup;
  carregando = true;

  constructor(
    private fb: FormBuilder,
    private transacoesService: TransacaoService
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      descricao: ['', Validators.required],
      valor: [0, [Validators.required, Validators.min(0.01)]],
      data: ['', Validators.required]
    });

    this.transacoesService.getTransacaoId(this.transacaoId).subscribe(transacao => {
      this.form.patchValue(transacao);
      this.carregando = false;
    });
  }

  salvar(): void {
    if (this.form.valid) {
      // this.transacoesService.atualizarTransacao(this.transacaoId, this.form.value).subscribe(() => {
      //   this.aoAtualizar.emit();
      // });
    }
  }
}

