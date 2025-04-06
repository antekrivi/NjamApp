import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Restoran } from '../../interfaces/restoran';
import { RestoranService } from '../../services/restoran.service';

@Component({
  selector: 'app-restorani',
  standalone: false,
  templateUrl: './restorani.component.html',
  styleUrl: './restorani.component.css'
})
export class RestoraniComponent implements OnInit {

  restorani$!: Observable<Restoran[]>;
  odabraniRestoran: Restoran | null = null;
  
  constructor(private restoranService: RestoranService) {
  }
  
  ngOnInit(): void {
    this.restorani$ = this.restoranService.getRestoraniAsArray();
  }
  
  onRestoranClick(restoran: Restoran): void {
    console.log(`Clicked on restoran: ${restoran.imeRestorana}`);
    this.odabraniRestoran = restoran;
  }

  getOpterecenostClass(postotak: number): string {
    if (postotak < 40) return 'low';
    if (postotak < 70) return 'medium';
    return 'high';
  }

  getOpterecenostText(postotak: number): string {
    if (postotak < 40) return 'Niska';
    if (postotak < 70) return 'Srednja';
    return 'Visoka';
  }
}
