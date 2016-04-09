package UML.Module5;

public class Matrix {

    public int matrix [][];

    // Matrix constructor
    public Matrix(int n) {
        this.matrix = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public void printMatrix() {

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // sum matrix
    public void sumMatrix(Matrix m1, Matrix m2) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
            }
        }
    }

    // subtract matrix
    public void subtractMatrix(Matrix m1, Matrix m2) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
            }
        }
    }

}
