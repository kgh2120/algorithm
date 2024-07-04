import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] life = new int[n+1];
        Node[] graph = new Node[n + 1];
        boolean[] selected = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            life[left]++;
            life[right]++;

            graph[left] = new Node(right, graph[left]);
            graph[right] = new Node(left, graph[right]);
        }

        // 1 인 애들 먹기
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <=n ; i++) {
            if (life[i] == 1) {
                q.add(i);
            }
        }

        int numberOfSelected = 0;
        while (!q.isEmpty()) {
            Integer node= q.poll();

            if(life[node] == 0)
                continue;
            life[node]--;

            // 얘랑 연관된 애 중에서 목숨 남아있는 친구 찾아라. 그리고 걔의 친구들 라이프 깎고, 0이 되면 먹어라

            for(Node edge = graph[node]; edge != null; edge = edge.next) {
                if(life[edge.to] == 0 || selected[edge.to]) continue;
                selected[edge.to] = true;
                numberOfSelected++;
                for (Node e = graph[edge.to]; e != null; e = e.next) {
                    if(life[e.to] == 0) continue;
                    if (--life[e.to] == 1) {
                        q.add(e.to);
                    }
                }
            }
        }
        System.out.println(numberOfSelected);


    }

    static class Node{
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

}