package Practice.Lesson1;

/*
Обхід Матриці Змійкою

Обійти матрицю "змійкою" і повернути всі числа в одномірному масиві.
Наприклад:
Для
[[ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]]
повернути
[1, 4, 7, 8, 5, 2, 3, 6, 9]
 */

public class MatrixSnakeTraversal {

    public static void main(String[] args) {

        MatrixSnakeTraversal MatrixSnakeTraversal = new MatrixSnakeTraversal();
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        //int[][] array = {{6,7},{10,11}};
        for(int i: MatrixSnakeTraversal.print(array)) System.out.println(i);

    }

    public int[] print(int[][] input) {

        int h = input.length;
        int w = input[0].length;
        int index = 0;
        int[] result = new int[h*w];

        for(int j = 0; j < w; j++){
            for(int i = 0; i < h; i++){
                if(j%2==0)
                    result[index] = input[i][j];
                else
                    result[index] = input[h-i-1][j];
                index++;
            }
        }
        return result;
    }
}
