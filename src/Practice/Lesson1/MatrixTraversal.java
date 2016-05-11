package Practice.Lesson1;

/*
Обхід матриці по спіралі

Обійти матрицю по спіралі і записати всі числа в одмірний масив.
Для матриці
[[1,   2,  3,  4],
 [5,   6,  7,  8]
 [9,  10, 11, 12]
 [13, 14, 15, 16]]
вивести [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 */

public class MatrixTraversal {

    public static void main(String[] args) {

        MatrixTraversal matrixTraversal = new MatrixTraversal();
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        //int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        //int[][] array = {{6,7},{10,11}};
        for(int i: matrixTraversal.print(array)) System.out.println(i);

    }

    public int[] print(int[][] input) {

       int h = input.length;
       int w = input[0].length;
       int top = 0, left = 0, right = w - 1, bottom = h - 1;

       int[] result = new int[h*w];
       int index = 0;

       while (right >= left & bottom >= top) {

           if(right >= left & bottom >= top) {
               for (int i = left; i <= right; i++) {
                   result[index] = input[top][i];
                   index++;
               }
               top++;
           }

           if(right >= left & bottom >= top) {
               for (int i = top; i <= bottom; i++) {
                   result[index] = input[i][right];
                   index++;
               }
               right--;
           }

           if(right >= left & bottom >= top) {
               for (int i = right; i >= left; i--) {
                   result[index] = input[bottom][i];
                   index++;
               }
               bottom--;
           }

           if(right >= left & bottom >= top) {
               for (int i = bottom; i >= top; i--) {
                   result[index] = input[i][left];
                   index++;
               }
               left++;
           }

       }
       return result;
    }
}
