package FrogTest;

import java.util.ArrayList;

public class Frog {

    private FrogStep locationStep;
    public enum Step {Forward, ForwardToTheCenter1, ForwardToTheCenter2, ForwardOutOfCenter1, ForwardOutOfCenter2};

    Frog(FrogStep locationStep) {
        this.locationStep = locationStep;
    }

    public static boolean CanDoAStep(FrogStep parentStep, Step step, int[][] forest) {
        boolean result = true;
        int xNew = parentStep.getX(), yNew = parentStep.getY();

        if(step == Step.Forward) {
            yNew+=3;
        } else if(step == Step.ForwardToTheCenter1) {
            xNew-=1;
            yNew+=2;
            if(parentStep.getX() < 2) result = false;
        } else if(step == Step.ForwardToTheCenter2) {
            xNew-=2;
            yNew+=1;
            if(parentStep.getX() < 3) result = false;
        } else if(step == Step.ForwardOutOfCenter1) {
            xNew+=1;
            yNew+=2;
            if(parentStep.getX() > 9) result = false;
        } else if(step == Step.ForwardOutOfCenter2) {
            xNew+=2;
            yNew+=1;
            if(parentStep.getX() > 8) result = false;
        }

        if(result) {
            for(int i = 0; i < forest.length; i++){
                if(forest[i][0] == xNew && forest[i][1] == yNew) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public static FrogStep moveStep(FrogStep parentStep, Step step) {

        int xNew = parentStep.getX(), yNew = parentStep.getY();

        if(step == Step.Forward) {
            yNew+=3;
        } else if(step == Step.ForwardToTheCenter1) {
            xNew-=1;
            yNew+=2;
        } else if(step == Step.ForwardToTheCenter2) {
            xNew-=2;
            yNew+=1;
        } else if(step == Step.ForwardOutOfCenter1) {
            xNew+=1;
            yNew+=2;
        } else if(step == Step.ForwardOutOfCenter2) {
            xNew+=2;
            yNew+=1;
        }

        if(yNew > 16) yNew-=16;

        FrogStep newStep = new FrogStep(parentStep, xNew, yNew);
        return newStep;

    }

    public FrogStep getLocationStep() {
        return locationStep;
    }

}
