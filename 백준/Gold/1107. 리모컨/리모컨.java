import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * - @author 규현
 * - @since 2024-03-16
 * - @limit memory :  time :
 * - @performance
 * - @category
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> numbers;
    static int target;

    static int min;


    public static void main(String[] args) throws Exception {

        target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(0, 1,2,3,4,5,6,7,8,9));

        if (n != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                numbers.remove(Integer.valueOf(st.nextToken()));
            }
        }

        min = Math.abs(target - 100);
        createNumber(new StringBuilder(), 0);
        System.out.println(min);
    }

    static void createNumber(StringBuilder word, int depth){
        if (depth == 7) {

            if (word.length() == 0) {
                return;
            }

            int num = Integer.parseInt(word.toString());

            min  = Math.min(min, calcDistance(num));
            return;
        }
        createNumber(word, depth+1);
        for (Integer number : numbers) {
            word.append(number);
            createNumber(word, depth+1);
            word.deleteCharAt(word.length()-1);
        }
    }

    static int calcDistance(int number){
        return Integer.toString(number).length() + Math.abs(number - target);
    }





}