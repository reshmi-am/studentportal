
import { Component, Input} from '@angular/core';
import { WebEntity } from './../webentity';

@Component({
  selector: 'alert',
  templateUrl: './alert.component.html'
})
export class AlertComponent extends WebEntity{

    @Input() display: boolean = false;
    @Input() msg: string = "";

    showDialog() {
        this.display = true;
    }
    hide(){
        this.display = false;
        this.msg = "";
    }
}
