package UML.Files;

/**
 * Created by v.babiak on 27.05.2016.
 */
public class IncorrectSymbol extends Exception{

    public IncorrectSymbol(String name, String message) {
        super("Name " + name + " contains the incorrect symbol " + message);
    }

}
