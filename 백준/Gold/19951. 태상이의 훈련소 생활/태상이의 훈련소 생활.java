import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] values = new int[n+2];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            values[startIdx] += value;
            values[endIdx+1] -= value;
        }

        int curValue = 0;
        int idx = 1;
        while (idx <= n) {
            // st가 있으면 check
            curValue += values[idx];
            arr[idx++] += curValue;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<=n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

}