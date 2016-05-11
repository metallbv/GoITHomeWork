package SoftServe.Practice1;

public class Fruit implements IJuiceable, ISliceable{

    private String name;

    public String makeJuice() {
        return "Juice from " + name;
    }

    public String makeSlice() {
        return "Slices of " + name;
    }
}
