import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { providePrimeNG } from 'primeng/config';
import Aura from '@primeng/themes/aura';
import {provideRouter} from '@angular/router';
import {routes} from './app/app.routes';
import {provideAnimations} from '@angular/platform-browser/animations';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),
    provideAnimations(),
    providePrimeNG({
      theme: {
        preset: Aura
      }
    })
  ]
});
