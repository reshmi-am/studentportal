
import { Component, Input} from '@angular/core';

@Component({
  selector: 'alert',
  templateUrl: './alert.component.html'
})
export class AlertComponent {

    @Input() display: boolean = false;
    @Input() message: string = "";

    showDialog() {
        this.display = true;
    }
    toggleDisplay(){
        this.display = false;
        this.message = "";
    }
}
