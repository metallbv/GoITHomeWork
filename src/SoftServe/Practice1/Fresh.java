package SoftServe.Practice1;

import java.util.ArrayList;

public class Fresh {

    private ArrayList<Fruit> Juices = new ArrayList<>();
    private ArrayList<Fruit> Slices = new ArrayList<>();

    public void addToJuice(Fruit fruit) {
        Juices.add(fruit);
    }

    public void addToSlice(Fruit fruit) {
        Slices.add(fruit);
    }

    public void makeFresh() {

        for (Fruit fruit : Juices) {
            fruit.makeJuice();
        }

        for (Fruit fruit : Slices) {
            fruit.makeSlice();
        }
    }
}
