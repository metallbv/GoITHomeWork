package UML.Flowers;

public class Rose extends Flower {

    private Rosebush rosebush;

    public Rose(String name){
        super(name);
    }

    public Rose(String name, Rosebush rosebush) {
        super(name);
        this.rosebush = rosebush;
        rosebush.addRose(this);
    }

    public Rosebush getRosebush(){
        return rosebush;
    }

}
