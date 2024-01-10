import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*

  14938 서강그라운드

  어떤 위치에서 떨어졌을 때, 수색 범위m 에 속하는 만큼의 개수를 먹을 수 있음.
  그럴 때 최대로 획득할 수 있는 아이템의 개수를 구하는 문제이다.

  그럼 특정 위치 A에서 다른 위치까지의 거리를 전부 알아야 함.

  그럼 다익스트라를 n번 돌리거나 플로이드 워셜을 써가지고 풀 수 있을 듯 함.

  그런데 전부 체크를 해야 하니까 플로이드 워셜이 좋ㅇ으려나?

  다익스트라는 e log n을 n번 반복/ 플로이드 워셜을 n^3이다.

  n이 100, 길의 개수가 100개임. 다익스트라가 더 빨라보이긴 한데, 플로이드 워셜로 돌리는게 더 편해보인다.
 */
public class Main {

    public static final int INF = 10_0000_0000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] matrix = new int[n + 1][n + 1];


        for (int[] anInt : matrix) {
            Arrays.fill(anInt, INF);
        }

        for (int i = 1; i <=n ; i++) {
            matrix[i][i] = 0;
        }


        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            matrix[f][t] = l;
            matrix[t][f] = l;
        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }


        int max = 0;

        for (int i = 1; i <= n; i++) {
            List<Integer> loadList = new ArrayList<>();
            int tempMax = 0;
            for (int j = 1; j <= n ; j++) {
                if (matrix[i][j] <= m) {
                    loadList.add(j);
                }
            }

            for (Integer integer : loadList) {
                tempMax += items[integer];
            }

            max = Math.max(max, tempMax);
        }

        System.out.println(max);
    }


}