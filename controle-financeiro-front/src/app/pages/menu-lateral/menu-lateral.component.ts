import { Component } from '@angular/core';
import { SidebarModule } from 'primeng/sidebar';
import { PanelMenuModule } from 'primeng/panelmenu';
import { ButtonModule } from 'primeng/button';
import { MenuItem } from 'primeng/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-lateral',
  standalone: true,
  imports: [SidebarModule, PanelMenuModule, ButtonModule],
  templateUrl: './menu-lateral.component.html',
  styleUrls: ['./menu-lateral.component.scss']
})
export class MenuLateralComponent {
  visible = false;

  items: MenuItem[] = [];

  constructor(private router: Router) {
    this.items = [
      {
        label: 'Dashboard',
        icon: 'pi pi-fw pi-home',
        command: () => {
          this.router.navigate(['/dashboard']);
          this.visible = false;
        }
      },

      {
        label: 'Relatórios',
        icon: 'pi pi-fw pi-chart-line',
        items: [
          {
            label: 'Transações',
            icon: 'pi pi-fw pi-table',
            command: () => {
              this.router.navigate(['/relatorios/transacoes'])
              this.visible = false;
            }
          }
        ]
      },
      {
        label: 'Configurações',
        icon: 'pi pi-fw pi-cog',
        command: () => {
          this.router.navigate(['/configuracoes']);
          this.visible = false;
        }
      }
    ];
  }
}
