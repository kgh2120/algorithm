import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static  int[] parents;

    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            sb.append("Scenario ").append(i).append(":\n");

            int nOfPeople = Integer.parseInt(br.readLine());
            parents = initParents(nOfPeople);
            int k = Integer.parseInt(br.readLine());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                union(left,right);
            }

            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                int answer = 0;
                if (find(left) == find(right)) {
                    answer = 1;
                }
                sb.append(answer).append("\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int l, int r){

        int left = find(l);
        int right = find(r);

        if (left <= right) {
            parents[right] = left;
        }else
            parents[left] = right;

    }
    private static int find(int number) {
        if(parents[number] == number) return number;
        return parents[number] = find(parents[number]);
    }

    private static int[] initParents(int n){
        int[] parents = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            parents[i] = i;
        }
        return parents;

    }

}