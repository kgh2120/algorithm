import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 :
    @입력 범위 :
    @문제 내용 :
    @주의 사항 :
    @예상 알고리즘 :
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean [] visited;
    static Map<Integer, Set<Integer>> bit;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[(int)Math.pow(2,n)];

        int t = (int) Math.pow(2, n-k-1);
        int max = (int)Math.pow(2, n) -1 ;

        int a = 0;
        for (int i = 0; i < Math.pow(2, n-1); i++) {

            int other = max - i;
            sb.append(i).append(" ").append(other).append(" ");

            if (++a == t) {
                a = 0;
                sb.append("\n");
            }

        }
        System.out.println(sb);

    }


}