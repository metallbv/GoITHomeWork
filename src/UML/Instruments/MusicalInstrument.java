package UML.Instruments;

public class MusicalInstrument {

    private String name;
    private Shop shop;

    public MusicalInstrument(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setShop(Shop shop){
        this.shop = shop;
    }

    public String getName(){
        return name;
    }

    public Shop getShop(){
        return shop;
    }
}
