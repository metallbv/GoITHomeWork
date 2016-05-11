package FrogTest;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static FrogTest.Frog.CanDoAStep;
import static FrogTest.Frog.moveStep;

public class FrogAlgoritm {

    private Queue<FrogStep> queueStep = new LinkedList<FrogStep>();
    private ArrayList<FrogStep> usedStep = new ArrayList<>();

    public static void main(String[] args) {

        int xDestination = 10, yDestination = 9;
        FrogStep startStep = new FrogStep(null, 7, 11);
        FrogStep destinationStep = new FrogStep(null, 10, 9);
        int [][] forest = {{8, 5}, {9, 14}};
        Frog bettyFrog = new Frog(startStep);

        FrogAlgoritm frogAlgoritm = new FrogAlgoritm();
        frogAlgoritm.find(startStep, forest, destinationStep);

    }

    private void find(FrogStep startStep, int[][] forest, FrogStep destinationStep) {

        Frog.Step[] allStep = Frog.Step.values();

        // если шаг делали - пропускаем его
        if(usedStep.contains(startStep)) {
            return;
        }

        queueStep.add(startStep);
        usedStep.add(startStep);

        for(Frog.Step step : allStep) {

            if (CanDoAStep(startStep, step, forest)) {
                FrogStep newStep = moveStep(startStep, step);
                if (!usedStep.contains(newStep)) {
                    queueStep.add(newStep);
                    usedStep.add(newStep);
                }
            }

        }

    }


}
