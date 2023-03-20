import java.util.Arrays;
import java.util.Comparator;

public class Main2 {



    public String solution(int[] numbers) {

        int a = 7;
        int b = 3;
        int c = 5;
        System.out.println(a^b + (b^c) + (a^c));

        return "";
//        return sb.toString();
    }



    public static void main(String[] args) throws Exception {
        int [] a = {6, 10, 2};
        int[][]b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        String s = new Main2().solution(a);
        System.out.println(s);
    }

}
