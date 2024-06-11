import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        int next = 0;
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        if (isNumber(a)) {
            next = 3;
            number = Integer.parseInt(a);
        }
        else if (isNumber(b)) {
            next = 2;
            number = Integer.parseInt(b);
        }
        else if (isNumber(c)) {
            next = 1;
            number = Integer.parseInt(c);
        }

        int nextNumber = number+next;

        if(nextNumber % 3 == 0 && nextNumber % 5 == 0) System.out.println("FizzBuzz");
        else if(nextNumber % 3 == 0 ) System.out.println("Fizz");
        else if(nextNumber % 5 == 0) System.out.println("Buzz");
        else System.out.println(nextNumber);
    }

    private static boolean isNumber(String text){
        return  text.charAt(0) != 'F' && text.charAt(0) != 'B';
    }


}