import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static Set<Integer> failCase;
    static String target;
    public static void main(String[] args) throws Exception {
        target = br.readLine();
        String cur = br.readLine();

        System.out.println(canTransform(new StringBuilder(cur)) ? 1 : 0);

    }



    private static boolean canTransform(StringBuilder cur) {
        if (cur.length() == target.length()) {
            return cur.toString().equals(target);
        }else{

            // cur의 마지막을 체크.
            int last = cur.length()-1;
            char lastChar = cur.charAt(last);
            cur.deleteCharAt(last);
            if (lastChar == 'B') {
              cur.reverse();
            }
            return canTransform(cur);
        }
    }


}