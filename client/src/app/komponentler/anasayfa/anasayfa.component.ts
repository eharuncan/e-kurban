import { Component, OnInit } from '@angular/core';
import { Kurban } from '../../modeller/kurban';
import { KurbanService } from '../../servisler/kurban.service';

@Component({
  selector: 'app-anasayfa',
  templateUrl: './anasayfa.component.html',
  styleUrls: [ './anasayfa.component.css' ]
})
export class AnasayfaComponent implements OnInit {
  kurbanlar: Kurban[] = [];

  constructor(private kurbanService: KurbanService) { }

  ngOnInit(): void {
    this.getKurbanlar();
  }

  getKurbanlar(): void {
    this.kurbanService.getKurbanlar()
      .subscribe(kurbanlar => this.kurbanlar = kurbanlar.slice(1, 5));
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/