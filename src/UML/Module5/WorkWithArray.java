package UML.Module5;

import java.util.Scanner;

public class WorkWithArray {

    // Look for smolest and biggest element of the array
    public void findSmallestBiggestElement(int [] arrayOfNumbers) {

        int smallestElement = arrayOfNumbers[0];
        int biggestElement = arrayOfNumbers[0];

        for (int i = 0; i < arrayOfNumbers.length; i++) {

            if (smallestElement > arrayOfNumbers[i]) {
                smallestElement = arrayOfNumbers[i];
            }

            if (biggestElement < arrayOfNumbers[i]) {
                biggestElement = arrayOfNumbers[i];
            }
        }

        System.out.println("The smolest element of the array " + smallestElement);
        System.out.println("The biggest element of the array " + biggestElement);

    }

    // Sort array Bubble
    public void sortBubble(int [] arrayOfNumbers) {

        for (int i = arrayOfNumbers.length - 1; i > 0; i --) {

            for (int j = 0; j < i; j ++) {

                if (arrayOfNumbers[j] > arrayOfNumbers[j+1]) {
                    int tmp = arrayOfNumbers[j];
                    arrayOfNumbers[j] = arrayOfNumbers[j+1];
                    arrayOfNumbers[j+1] = tmp;
                }
            }
        }

        System.out.println("Sorted bubble:");

        for (int element : arrayOfNumbers) {
            System.out.print(element + " ");
        }
        System.out.println();

    }

    // Sort array selection
    public void sortSelection(int [] arrayOfNumbers) {

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            int min = arrayOfNumbers[i];
            int min_i = i;

            for (int j = i + 1; j < arrayOfNumbers.length; j++) {
                if (arrayOfNumbers[j] < min) {
                    min = arrayOfNumbers[j];
                    min_i = j;
                }
            }

            if (i != min_i) {
                int tmp = arrayOfNumbers[i];
                arrayOfNumbers[i] = arrayOfNumbers[min_i];
                arrayOfNumbers[min_i] = tmp;
            }
        }

        System.out.println("Sorted selection:");

        for (int element : arrayOfNumbers) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Sort array insertion
    public void sortInsertion(int [] arrayOfNumbers) {

        for (int i = 1; i < arrayOfNumbers.length; i++) {
            int value = arrayOfNumbers[i];
            int j;
            for (j = i - 1; j >= 0 && arrayOfNumbers[j] > value; j--) {
                arrayOfNumbers[j + 1] = arrayOfNumbers[j];
            }
            arrayOfNumbers[j + 1] = value;
        }

        System.out.println("Sorted insertion:");

        for (int element : arrayOfNumbers) {
            System.out.print(element + " ");
        }
        System.out.println();

    }

}
