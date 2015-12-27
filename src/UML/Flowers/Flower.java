package UML.Flowers;

public class Flower {

    private String name;
    private Bouquet bouquet;

    public Flower(){

    }

    public Flower(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBouquet(Bouquet bouquet){
        this.bouquet = bouquet;
    }

    public String getName(){
        return name;
    }

    public Bouquet getBouquet(){
        return bouquet;
    }

}
