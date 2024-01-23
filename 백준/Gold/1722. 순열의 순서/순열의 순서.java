import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static long[] factorial;

    static List<Integer> number;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int type;
    static long problem;
    static int[] target;
    static long answer;
    public static void main(String[] args) throws Exception {


        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        type = Integer.parseInt(st.nextToken());

        if (type == 1) {
            problem = Long.parseLong(st.nextToken());
        }else{
            target = new int[n];
            for (int i = 0; i < n; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }
        }


        factorial = new long[n+1];

        factorial[0] = 1;
        for (int i = 1; i <= n ; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        number = new ArrayList<>(20);
        for (int i = 1; i <= n ; i++) {
            number.add(i);
        }

        if (type == 1) {
            problem--;
            problem1(1);
        }else{
            problem2(1);

        }

        System.out.println(sb);

    }

    static void problem1(int depth){
        if (depth == n+1) {
            return;
        }
        int index = (int) (problem / factorial[n - depth]);
        problem %= factorial[n - depth];
        Integer cur = number.remove(index);
        sb.append(cur).append(" ");
        problem1(depth+1);
    }

    static void problem2(int depth){
        if (depth == n+1) {
            sb.append(answer+1);
            return;
        }
        int index = number.indexOf(target[depth - 1]);
        answer += factorial[n - depth] * index;
        number.remove(index);
        problem2(depth+1);

    }

}