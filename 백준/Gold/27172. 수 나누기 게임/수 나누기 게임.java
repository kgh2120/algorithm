import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 모든 수를 입력 받는다.
    // 1~1_000_000까지의 TF체크 배열을 만든다.
    // PLUS
    // 각 수의 plus, minum를 관리하는 배열도 만듦.

    static int[]arr;
    static boolean[] tf;
    static long[] pm;
    static int maxNum;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tf = new boolean[1_000_001];
        pm = new long[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tf[arr[i]] = true;
            maxNum = Math.max(arr[i], maxNum);
        }

        for (int i : arr) {
            filter(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(pm[i]).append(" ");
        }
        System.out.println(sb);


    }


    private static void filter(int num){

        for (int i = 2; num * i <= maxNum; i++) {
            if (tf[num * i]) {
                pm[num]++;
                pm[num*i]--;
            }
        }
    }


}