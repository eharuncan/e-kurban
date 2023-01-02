import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {GirisComponent} from "./giris/giris.component";
import {AnasayfaComponent} from './anasayfa/anasayfa.component';
import {KurbanlarComponent} from './kurbanlar/kurbanlar.component';
import {KurbanEkleComponent} from "./kurban-ekle/kurban-ekle.component";
import {KurbanBilgiComponent} from './kurban-bilgi/kurban-bilgi.component';
import {HissedarlarComponent} from "./hissedarlar/hissedarlar.component";
import {HissedarEkleComponent} from "./hissedar-ekle/hissedar-ekle.component";

const routes: Routes = [
    {path: '', redirectTo: '/anasayfa', pathMatch: 'full'},
    {path: 'giris', component: GirisComponent},
    {path: 'anasayfa', component: AnasayfaComponent},
    {path: 'kurbanlar', component: KurbanlarComponent},
    {path: 'kurban-ekle', component: KurbanEkleComponent},
    {path: 'kurban-bilgi/:id', component: KurbanBilgiComponent},
    {path: 'hissedarlar', component: HissedarlarComponent},
    {path: 'hissedar-ekle', component: HissedarEkleComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/