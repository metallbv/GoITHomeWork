package UML.Flowers;

import java.util.ArrayList;

public class Bouquet {

    private String name;
    private ArrayList<Flower> flowers = new ArrayList<Flower>();

    public Bouquet(String name){
        this.name = name;
    }

    public Bouquet(String name, ArrayList<Flower> flowers){
        this.name = name;
        this.flowers = flowers;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFlowers(ArrayList<Flower> flowers){
        this.flowers = flowers;
    }

    public void addFlower(Flower flower){
        flowers.add(flower);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Flower> getFlowers(){
        return flowers;
    }

    public void deleteFlower(Flower flower){
        flowers.remove(flower);
    }
}
