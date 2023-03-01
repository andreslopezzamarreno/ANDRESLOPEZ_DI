import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AniadirComponent } from './components/aniadir/aniadir.component';

const routes: Routes = [{ path: 'cursos/:ciclo', component: AniadirComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
