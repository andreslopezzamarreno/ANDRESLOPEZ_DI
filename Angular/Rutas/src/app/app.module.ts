import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UnoComponentComponent } from './components/uno-component/uno-component.component';
import { DosComponentComponent } from './components/dos-component/dos-component.component';
import { ComunicarComponent } from './components/comunicar/comunicar.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    UnoComponentComponent,
    DosComponentComponent,
    ComunicarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
