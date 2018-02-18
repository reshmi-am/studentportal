import {Injectable, EventEmitter} from '@angular/core';
import { Subject } from 'rxjs/Subject';
import { Router, RoutesRecognized } from '@angular/router';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/pairwise';

@Injectable()
export class EventEmitService {

    // Observable string sources
    private emitChangeSource = new Subject<any>();
    // Observable string streams
    changeEmitted$ = this.emitChangeSource.asObservable();
    // Service message commands
    emitLoginSuccess(change: any) {
        this.emitChangeSource.next(change);
    }

}
