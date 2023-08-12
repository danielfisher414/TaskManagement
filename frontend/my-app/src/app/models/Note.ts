export class Note{
    private name: string;
    private description: string;

    constructor(name:string, description:string) {
        this.name = name;
        this.description = description;
    }

        get _name():string{
            return this._name;
        }

        set _name(newName:string){
             this._name = newName;
        }


        get _description():string{
            return this.description;
        }
    
        set _description(newName:string){
            this.description = newName;
       }

       
}