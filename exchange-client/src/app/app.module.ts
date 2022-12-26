import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {ConverterComponent} from "./components/converter/converter.component";
import {NavigationComponent} from "./components/navigation/navigation.component";
import {LoginComponent} from "./pages/login/login.component";
import {RouterModule, Routes} from "@angular/router";
import {ConversionComponent} from "./pages/conversion/conversion.component";
import {HistoryComponent} from "./pages/history/history.component";
import {FooterComponent} from "./components/footer/footer.component";
import {HttpClientModule} from "@angular/common/http";

const appRoutes: Routes =[
  { path: '', component: LoginComponent},
  { path: 'conversion', component: ConversionComponent},
  { path: 'history', component: HistoryComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    ConverterComponent,
    NavigationComponent,
    LoginComponent,
    ConversionComponent,
    HistoryComponent,
    FooterComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [
    AppComponent,
    ConverterComponent,
    NavigationComponent,
    LoginComponent,
    ConversionComponent,
    HistoryComponent,
    FooterComponent
  ]
})
export class AppModule { }
