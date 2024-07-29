import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int INF = 10_0000_0000;

    public static void main(String[] args) throws Exception {


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n+1][n+1];
        int [][]path = new int[n+1][n+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i==j) continue;
                matrix[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (matrix[from][to] > weight) {
                matrix[from][to] = weight;
                path[from][to] = from;
            }

        }


        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <=n ; i++) {
                for (int j = 1; j <=n ; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                int value = matrix[i][j];
                if(value == INF) value = 0;
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (path[i][j] == 0) {
                    sb.append(0).append("\n");
                    continue;
                }
                StringBuilder sub = new StringBuilder();
                int k = findPath(sub, path, i, j) +1;
                sb.append(k).append(" ").append(sub).append(j).append("\n");
            }
        }
        System.out.println(sb);

    }

    static int findPath(StringBuilder sb, int[][] path, int i, int j){

        if (path[i][j] == 0) {
            return 0;
        }

        int val = findPath(sb, path, i, path[i][j])+1;
        sb.append(path[i][j]).append(" ");
        return val;

    }



}