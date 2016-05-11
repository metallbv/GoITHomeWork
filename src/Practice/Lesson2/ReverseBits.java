package Practice.Lesson2;

/*
Біт Реверс

Для даного числа поміняти всі біти місцями відносно центра.
Наприклад:
Для 2 (10) повернути 1073741824 (01000000000000000000000000000000).
 */

public class ReverseBits {

    public static void main(String[] args) {

        ReverseBits reverseBits = new ReverseBits();
        System.out.println(Integer.toBinaryString(123456789));
        System.out.println(reverseBits.reverse(123456789));
        System.out.println(Integer.toBinaryString(reverseBits.reverse(123456789)));
    }

    public int reverse(int input) {

        int mask = 0;
        int result = 0;

        for(int i = 0; i < 32; i++){
            if(((input>>i)&1)==1){
                mask = 1<<(31-i);
                result = result|mask;
            }
            else{
                mask = ~(1<<(31-i));
                result = result&mask;
            }
        }

        return result;
    }
}
