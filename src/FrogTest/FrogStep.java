package FrogTest;

public class FrogStep {

    final FrogStep parentStep;
    final int x, y;

    FrogStep(FrogStep parentStep, int x, int y) {
        this.parentStep = parentStep;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;}

    public boolean equals(FrogStep newStep) {
        if(x==newStep.getX() && y == newStep.getY())
            return true;
        else
            return false;
    }

}
