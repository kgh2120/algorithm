import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static String str;
    static Map<String, Integer> stringToIntegerMap;
    static Map<Character, String> charToStringMap;

    public static void main(String[] args) throws Exception {
        init();

        // str 진행하면서 찾기.

        StringBuilder firstAnswerBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        long number = 0;
        Deque<Word> queue = new ArrayDeque<>();
        boolean directOperate = false;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(c);
                if (stringToIntegerMap.containsKey(sb.toString())) {
                    Integer convertedNumber = stringToIntegerMap.get(sb.toString());
                    firstAnswerBuilder.append(convertedNumber);
                    number = number * 10 + convertedNumber;
                    sb = new StringBuilder();
                }
            } else {
                if (number == 0) {
                    System.out.println("Madness!");
                    return;
                }
                firstAnswerBuilder.append(c);
                queue.addLast(new Word(number, c));
                number = 0;
            }
        }

        // 이젠 덧셈 뺄셈만 하면 됨.


        char ops;

        Word left = queue.pollFirst();
        while (!queue.isEmpty()) {
            Word right = queue.pollFirst();
            long newNumber = operate(left.value, right.value, left.operator);
            left.value = newNumber;
            left.operator = right.operator;
        }

        System.out.println(firstAnswerBuilder);
        StringBuilder secondAnswerBuilder = new StringBuilder();

        String leftStr  = Long.toString(left.value);

        for (char c : leftStr.toCharArray()) {
            if(c == '-')
                secondAnswerBuilder.append(c);
            else
                secondAnswerBuilder.append(charToStringMap.get(c));
        }

        System.out.println(secondAnswerBuilder);





    }

    private static long operate(long a, long b, char ops) {

        switch (ops) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '/':
                return a / b;
            default:
                return -1;
        }
    }


    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        stringToIntegerMap = new HashMap<>();
        stringToIntegerMap.put("ONE", 1);
        stringToIntegerMap.put("TWO", 2);
        stringToIntegerMap.put("THREE", 3);
        stringToIntegerMap.put("FOUR", 4);
        stringToIntegerMap.put("FIVE", 5);
        stringToIntegerMap.put("SIX", 6);
        stringToIntegerMap.put("SEVEN", 7);
        stringToIntegerMap.put("EIGHT", 8);
        stringToIntegerMap.put("NINE", 9);
        stringToIntegerMap.put("ZERO", 0);

        charToStringMap = new HashMap<>();
        charToStringMap.put('1', "ONE");
        charToStringMap.put('2', "TWO");
        charToStringMap.put('3', "THREE");
        charToStringMap.put('4', "FOUR");
        charToStringMap.put('5', "FIVE");
        charToStringMap.put('6', "SIX");
        charToStringMap.put('7', "SEVEN");
        charToStringMap.put('8', "EIGHT");
        charToStringMap.put('9', "NINE");
        charToStringMap.put('0', "ZERO");


    }

    static class Word {
        long value;
        char operator;

        public Word(long value, char operator) {
            this.value = value;
            this.operator = operator;
        }
    }


}