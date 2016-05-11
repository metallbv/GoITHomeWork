package Practice.Lesson2;

/*
Бітовий Поліндром

Перевірити чи являється бінарне представлення числа поліндромом.
 */

public class BitsPalindrome {

    public static void main(String[] args) {

        BitsPalindrome bitsPalindrome = new BitsPalindrome();
        //int number = -2147483647;
        int number = -2147483646;
        System.out.println(Integer.toBinaryString(number));
        System.out.println("Number " + number + " is polindrom " + bitsPalindrome.isPalindrome(number));

    }

    public boolean isPalindrome(int input){

        boolean result = true;

        int leftside = 0;
        int rightside = 0;

        for(int i = 0; i < 16; i++){
            leftside = (input>>(i+16))&1;
            rightside = (input>>(15-i))&1;
            if(leftside != rightside){
                result = false;
                break;
            }
        }

        return result;
    }
}
