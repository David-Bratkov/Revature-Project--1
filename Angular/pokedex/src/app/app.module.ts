import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PokesearchComponent } from './pages/pokesearch/pokesearch.component';
import { PokedetailsComponent } from './pages/pokedetails/pokedetails.component';
import { PokenavComponent } from './components/pokenav/pokenav.component';
import { PokelistComponent } from './components/pokelist/pokelist.component';
import { PokecardComponent } from './components/pokecard/pokecard.component';

@NgModule({
  declarations: [
    AppComponent,
    PokesearchComponent,
    PokedetailsComponent,
    PokenavComponent,
    PokelistComponent,
    PokecardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
