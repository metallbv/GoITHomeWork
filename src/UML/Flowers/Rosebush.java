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

    public void addRose(Rose rose){
        roses.add(rose);
    }

    public ArrayList<Rose> getRoses(){
        return roses;
    }

    public void deleteRose(Rose rose) throws IllegalStateException{
        if (roses.isEmpty() || !roses.contains(rose)) {
            throw new IllegalStateException("" + this + "hasn't contains rose " + rose);
        } else {
            roses.remove(rose);
        }
    }

}
