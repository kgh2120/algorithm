
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String con = sc.next();
        Stack<Character> stack = new Stack<>();
        boolean prev = false;
        int result = 0;
        for (char c : con.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                prev = false;
            }else{
                stack.pop();
                if (prev) {
                    result++;
                }else{
                    result += stack.size();
                }
                prev = true;
            }
        }
        System.out.println(result);

    }
}