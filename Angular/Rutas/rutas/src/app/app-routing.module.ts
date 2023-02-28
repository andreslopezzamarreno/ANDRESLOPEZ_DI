import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComunicarComponent } from './components/comunicar/comunicar.component';
import { DosComponentComponent } from './components/dos-component/dos-component.component';
import { HomeComponent } from './components/home/home.component';
import { UnoComponentComponent } from './components/uno-component/uno-component.component';

const routes: Routes = [
  { path: 'uno', component: UnoComponentComponent },
  { path: 'dos', component: DosComponentComponent },
  { path: 'comunicar', component: ComunicarComponent },
  { path: 'home', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
