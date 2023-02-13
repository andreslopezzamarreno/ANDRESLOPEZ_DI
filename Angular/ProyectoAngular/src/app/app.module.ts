import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicialComponent } from './componets/inicial/inicial.component';
import { SecundarioComponent } from './componets/secundario/secundario.component';

@NgModule({
  declarations: [
    AppComponent,
    InicialComponent,
    SecundarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
