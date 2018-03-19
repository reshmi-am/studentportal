export class WebEntity{

    private showalert:boolean = false;
    private message: string = "";

    showAlert(message : string){
        this.showalert = true;
        this.message = message;
    }

    hideAlert(){
        this.showalert = false;
        this.message = "";
    }
}