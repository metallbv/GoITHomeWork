package Practice.Lesson5;

/*
Парсер Числа

Дано рядок, що представляє певне чило. Необхідно повернути число.
Якщо це неможливо, повернути null
Наприклад:
"-2.e10"
"+.3"
".e2" повертає null
Складна
State Machine
 */

public class Doubles {

    public static void main(String[] args) {

        Doubles doubles = new Doubles();
        System.out.println(doubles.parse("-2.e10"));
        System.out.println(doubles.parse("+.3"));
        System.out.println(doubles.parse(".e2"));
    }

    public Double parse(String s) {

        StateMachine sm = new StateMachine();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            sm.next(letter, null);
        }

        return sm.getResult();
    }

    public static class StateMachine {

        public State currentState = State.INIT;
        ParseData data = new ParseData();

        public Double getResult() {

            if (currentState == State.NUMBER) {
                return new Double(data.getNumber());
            }
            return null;
        }

        public enum State {
            INIT {
                @Override
                public State next(char letter, ParseData data) {
                    if (letter - '0' >= 0 && letter - '0' <= 9){
                        data.addDigit(letter - '0');
                        return NUMBER;}
                    return INVALID_END;
                }
            }, NUMBER {
                @Override
                public State next(char letter, ParseData data) {
                    if (letter - '0' >= 0 && letter - '0' <= 9) {
                        data.addDigit(letter - '0');
                        return NUMBER;
                    }

                    return INVALID_END;
                }
            }, VALID_END {
                @Override
                public State next(char letter, ParseData data) {
                    if (letter == ' ')
                        return VALID_END;
                    return INVALID_END;
                }
            }, INVALID_END {
                @Override
                public State next(char letter, ParseData data) {
                    return INVALID_END;
                }
            };


            public abstract State next(char letter, ParseData data);
        }

        public void next(char letter, ParseData data) {

            currentState = currentState.next(letter, data);
        }

    }

    public static class ParseData{
        private int number = 0;

        public void addDigit(int i) {
            number = number*10+i;
        }

        public int getNumber() {
            return number;
        }
    }

}
