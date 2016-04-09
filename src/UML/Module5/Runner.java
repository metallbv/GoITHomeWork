package UML.Module5;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // work with arrays
        System.out.println("Input size of array");
        int arraySize = sc.nextInt();

        if (arraySize > 0) {

            int[] arrayOfNumbers = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                arrayOfNumbers[i] = (int) (Math.random() * 100);
            }

            for (int element : arrayOfNumbers) {
                System.out.print(element + " ");
            }
            System.out.println();

            WorkWithArray wwa = new WorkWithArray();

            wwa.findSmallestBiggestElement(arrayOfNumbers);
            wwa.sortBubble(arrayOfNumbers);
            wwa.sortSelection(arrayOfNumbers);
            wwa.sortInsertion(arrayOfNumbers);

        }

        // work with matrix
        System.out.println("Input size of matrix");
        int matrixSize = sc.nextInt();

        Matrix m1 = new Matrix(matrixSize);
        m1.printMatrix();
        Matrix m2 = new Matrix(matrixSize);
        m2.printMatrix();
        Matrix m3 = new Matrix(matrixSize);
        m3.sumMatrix(m1, m2);
        m3.printMatrix();
        Matrix m4 = new Matrix(matrixSize);
        m4.subtractMatrix(m1, m2);
        m4.printMatrix();
    }

}
