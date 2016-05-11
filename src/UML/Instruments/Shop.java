package UML.Instruments;

import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<MusicalInstrument> musicalInstruments;

    public Shop(String name){
        this.name = name;
    }

    public Shop(String name, ArrayList<MusicalInstrument> musicalInstruments){
        this.name = name;
        this.musicalInstruments = musicalInstruments;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setListOfInstruments(ArrayList<MusicalInstrument> musicalInstruments) {
        this.musicalInstruments = musicalInstruments;
    }

    public void addMusicalInstrument(MusicalInstrument musicalInstrument){
        musicalInstruments.add(musicalInstrument);
    }

    public String getName(){
        return name;
    }

    public ArrayList<MusicalInstrument> getMusicalInstruments(){
        return musicalInstruments;
    }

    public void removeMusicalInstrument(MusicalInstrument musicalInstrument){
        musicalInstruments.remove(musicalInstrument);
    }

}
