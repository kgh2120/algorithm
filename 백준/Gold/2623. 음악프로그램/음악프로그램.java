import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;



/**

@author 규현
@since 2023-09-10
@url
@level
@try
@performance
@category #
@note
 남일이는 보조 피디들이 가져온 순서에 맞춰서 전체 가수들의 순서를 작성해야한다.
 피디들은 자기만의 순서를 가져오고 이 모든 순서를 만족하는 경우를 찾아야 함.

 이때 경우를 찾지 못하면 -1을 출력해야 함.

 위상 정렬 알고리즘을 이용해야 하는데,

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static Node[] graph;
    static int[] counts;

    static int n, nOfPD;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        nOfPD = Integer.parseInt(st.nextToken());

        graph = new Node[n+1]; // 자기 다음꺼 받아서 간선으로 넣어줌
        counts = new int[n+1];

        for (int i = 0; i < nOfPD; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            int before = Integer.parseInt(st.nextToken());

            // 인접 리스트 구성
            for (int j = 1; j < k; j++) {
                int cur = Integer.parseInt(st.nextToken());
                graph[before] = new Node(cur, graph[before]);
                before = cur;
                counts[cur]++;
            }
        }

        topologySort();
        for (int i = 1; i <= n; i++) {
            if (counts[i] != 0) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);


    }

    private static void topologySort(){
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            if(counts[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            append(poll);
            for (Node node = graph[poll]; node != null; node = node.next) {
                counts[node.value]--;
                if (counts[node.value] == 0) {
                    q.add(node.value);
                }
            }
        }

    }

    private static void append(Integer poll) {
        sb.append(poll).append("\n");
    }

    static class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }




}