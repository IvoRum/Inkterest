class Entry{
    private name:string;
    private description:string;
    private image:any;

    Entry(name:string,description:string,imgSRC:any,width:number,height:number){
        this.name=name;
        this.description=description;
        this.image=new Image(width,height);
        this.image.src=imgSRC;
    }

    public getDescription(){
        return this.description;
    }

    public getName(){
        return this.image;
    }

    private getImage(){
        return this.image;
    }
}