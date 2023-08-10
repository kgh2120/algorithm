import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m,r;
    static int[][] map;
    static int[] nofItems;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        nofItems = new int[n+1];
        map= new int[n+1][n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nofItems[i] = Integer.parseInt(st.nextToken());
        }

        for (int[] row : map) {
            Arrays.fill(row,100_000_000);
        }

        for(int i = 1; i<=n;i++)
            map[i][i] = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int f  = Integer.parseInt(st.nextToken());
            int t  = Integer.parseInt(st.nextToken());
            int d  = Integer.parseInt(st.nextToken());
            map[f][t] = d;
            map[t][f] = d;
        }



        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        // 각 지점별로 길이가 m 이하인 nOfItems를 더하낟.

        int max = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= m) {
                    count += nofItems[j];
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }





}