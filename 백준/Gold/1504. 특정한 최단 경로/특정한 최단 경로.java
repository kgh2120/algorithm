import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int INF = 10_0000_0000;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n+1][n+1];



        for (int i = 0; i<n+1; i++) {
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            matrix[f][t] = w;
            matrix[t][f] = w;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int k = 1; k<=n; k++){
            for (int i = 1; i<= n; i++){
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        long ansA = matrix[1][a] + matrix[a][b] + matrix[b][n];
        long ansB = matrix[1][b] + matrix[b][a] + matrix[a][n];

        long ans = 0;
        if(matrix[1][a] == INF || matrix[a][b] == INF || matrix[b][n] == INF)
            ansA = -1;
        if(matrix[1][b] == INF || matrix[b][a] == INF || matrix[a][n] == INF)
            ansB = -1;

        if(ansA != -1 && ansB != -1)
            ans = Math.min(ansA,ansB);
        else if(ansA == -1 && ansB != -1)
            ans = ansB;
        else ans = ansA;

        System.out.println(ans);


    }

}