package Practice.Lesson2;

/*
Бінарне Додавання

Додайте два беззнакових числа, що передаються як рядки.
"101" + "100" = "1001"
 */

public class AddBinary {

    public static void main(String[] args) {

        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.add("0","1"));

    }

    String add(String a, String b) {

        int aLength = a.length(), bLength = b.length();
        StringBuilder result = new StringBuilder();

        int ostacha = 0;
        int i = 0;
        while(i < aLength || i < bLength){
            char charA = i < aLength ? a.charAt(aLength - i - 1) : '0';
            char charB = i < bLength ? b.charAt(bLength - i - 1) : '0';
            int sum = (charA - '0') + (charB - '0') + ostacha;

            if(sum == 0){
                result.append('0');
                ostacha = 0;

            } else if(sum == 1){
                result.append('1');
                ostacha = 0;

            }else if(sum == 2){
                result.append('0');
                ostacha = 1;

            }else if(sum == 3){
                result.append('1');
                ostacha = 1;
            }

            i++;

        }

        if(ostacha > 0){
            result.append('1');
        }

        result.reverse();

        return result.toString();
    }
}
