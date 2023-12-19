import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());



        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.limit == o2.limit)
                    return Integer.compare(o1.cost, o2.cost) * -1;
                return Integer.compare(o1.limit, o2.limit) * -1;
            }
        });

        int t = nodes[0].limit;

        for (Node node : nodes) {
            if (node.limit < t) {
                t = node.limit;
            }
            t -= node.cost;
        }

        int answer = t >=0 ? t : -1;
        System.out.println(answer);
    }

    static class Node{
        int cost;
        int limit;

        public Node(int cost, int limit) {
            this.cost = cost;
            this.limit = limit;
        }
    }




}