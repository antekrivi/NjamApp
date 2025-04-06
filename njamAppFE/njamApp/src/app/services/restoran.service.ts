import { Injectable, OnInit } from '@angular/core';
import { Observable, of, forkJoin} from 'rxjs';
import { Restoran } from '../interfaces/restoran';

@Injectable({
  providedIn: 'root'
})
export class RestoranService {

  restorani!: Array<Observable<Restoran>>;

  constructor() {
    const restoran1: Restoran = {id: 1, imeRestorana: 'Restoran 1', adresa: 'Adresa 1', trenutnoOtvoreno: true, postotakOpterecenosti: 50};
    const restoran2: Restoran = {id: 2, imeRestorana: 'Restoran 2', adresa: 'Adresa 2', trenutnoOtvoreno: false, postotakOpterecenosti: 30};
    const restoran3: Restoran = {id: 3, imeRestorana: 'Restoran 3', adresa: 'Adresa 3', trenutnoOtvoreno: true, postotakOpterecenosti: 70};    

    this.restorani = [of(restoran1), of(restoran2), of(restoran3)];

  }

  getRestorani(): Array<Observable<Restoran>> {
    return this.restorani;
  }

  getRestoraniAsArray(): Observable<Restoran[]> {
    return forkJoin(this.restorani);
  }
}
