import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main2 {



    public String solution(int[] numbers) {

        List<Integer> a = new ArrayList<>();
        a.add(1);
        System.out.println(a.contains(1));

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
