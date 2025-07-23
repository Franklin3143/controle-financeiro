import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {MenuLateralComponent} from './pages/menu-lateral/menu-lateral.component';
import {HeaderComponent} from './layout/header/header.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MenuLateralComponent, RouterOutlet, HeaderComponent],
  template: `
    <app-header/>
    <app-menu-lateral />
    <router-outlet/>
  `
})
export class AppComponent {}

