package UML.Flowers;

public class Rose extends Flower {

    private Rosebush rosebush;

    public Rose(String name, Rosebush rosebush) {
        this.setName(name);
        this.rosebush = rosebush;
    }

    public Rosebush getRosebush(){
        return rosebush;
    }

}
