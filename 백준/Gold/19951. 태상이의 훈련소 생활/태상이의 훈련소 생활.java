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
        int[] start = new int[n+1];
        int[] end =  new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            start[startIdx] += value;
            end[endIdx] += value;
        }

        int curValue = 0;
        int idx = 1;
        while (idx <= n) {
            // st가 있으면 check
            curValue += start[idx];
            arr[idx] += curValue;
            curValue -= end[idx];
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<=n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
    
}