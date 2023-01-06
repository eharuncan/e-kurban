import {Component, Inject, OnInit} from '@angular/core';
import {Hissedar} from "../../models/hissedar";
import {HissedarService} from "../../services/hissedar.service";
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {HisseSecimMode} from "../../enums/hisseSecimMode";

export interface DialogData {
  mode: HisseSecimMode;
}

@Component({
    selector: 'app-hissedarlar',
    templateUrl: './hissedarlar.component.html',
    styleUrls: ['./hissedarlar.component.css']
})
export class HissedarlarComponent implements OnInit {
    // hissedarlar: Hissedar[] = HISSEDARLAR;
    hissedarlar: Hissedar[] = [];
    displayedColumns: string[] = ['ad', 'soyad', 'tel', 'islemler'];
    secilenHissedarId: number = 0;
    hisseSecimMode: HisseSecimMode = HisseSecimMode.KAPALI;

    constructor(private hissedarService: HissedarService,
                public dialogRef: MatDialogRef<HissedarlarComponent>,
                @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    }

    onIptalClick(): void {
        this.dialogRef.close();
    }

    onHissedarClick(hissedarId: number) {
      this.secilenHissedarId = hissedarId;
    }

    ngOnInit(): void {
        this.getHissedarlar();
        this.hisseSecimMode = this.data.mode;
    }

    getHissedarlar(): void {
        // this.hissedarlar = HISSEDARLAR;
        this.hissedarService.getHissedarlar()
            .subscribe(hissedarlar => this.hissedarlar = hissedarlar);
    }

    delete(hissedar: Hissedar): void {
        this.hissedarlar = this.hissedarlar.filter(h => h !== hissedar);
        this.hissedarService.deleteHissedar(hissedar.id).subscribe();
    }

}
