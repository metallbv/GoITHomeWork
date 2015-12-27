package UML.Flowers;

import java.util.ArrayList;

public class Rosebush {

    private String name;
    private ArrayList<Rose> roses = new ArrayList<Rose>();

    public Rosebush(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addRose(String name){
        Rose rose = new Rose(name, this);
        roses.add(rose);
    }

    public ArrayList<Rose> getRoses(){
        return roses;
    }

    public void deleteRose(Rose rose){
        roses.remove(rose);
    }
}
