import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[] arr;
    static int[]dp;
    static int[] parents;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        parents = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        Arrays.fill(dp, 1);

        int max = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    if(dp[i] < dp[j]+1){
                       dp[i] =  dp[j]+1;
                       parents[i] = j;
                    }
                }
            }

            if(max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }

        sb.append(max).append("\n");
        findParent(maxIndex);
//        sb.append(arr[maxIndex]);

        System.out.println(sb);




    }

    static int findParent(int v){
        if (v == parents[v]) {
            sb.append(arr[v]).append(" ");
            return v;
        }

        int parent = findParent(parents[v]);
        sb.append(arr[v]).append(" ");
        return parent;
    }




}
