import { Categoria } from './categoria.model';
import { Usuario } from './usuario.model';

export interface Transacao {
  id: number;
  descricao: string;
  valor: number;
  data: string;
  tipo: string;
  categoria: Categoria;
  usuario: Usuario;
}
