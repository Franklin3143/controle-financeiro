import { Component } from '@angular/core';
import {AvatarModule} from 'primeng/avatar';
import {ButtonModule} from 'primeng/button';
import {ToolbarModule} from 'primeng/toolbar';

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
  imports: [ToolbarModule, ButtonModule, AvatarModule]
})
export class HeaderComponent {}

