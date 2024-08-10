import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(input.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(from, to);
        }


        Arrays.sort(nodes);

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            Node cur = nodes[i];
            for (int j = i-1; j >=0 ; j--) {
                Node target = nodes[j];

                if(cur.to > target.to) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = -1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(n - (max + 1));
        
    }



    static class Node implements Comparable<Node> {
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
                int compare1 = Integer.compare(this.from, o.from);
                if (compare1 == 0) {
                    return Integer.compare(this.to, o.to);
                }
                return compare1;
            }
    }


}