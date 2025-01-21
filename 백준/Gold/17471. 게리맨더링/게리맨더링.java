import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    static Node[] graph;

    static int[] numberOfCitizen;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        init();
        comb(1, new boolean[n+1]);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);


    }

    static void init() throws Exception{
        n = Integer.parseInt(input.readLine());

        st = new StringTokenizer(input.readLine());

        numberOfCitizen = new int[n+1];
        graph = new Node[n+1];

        for(int i = 1; i<= n; i++){
            numberOfCitizen[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =1 ;i<=n;i++){
            st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());

            while(n-->0){
                int k = Integer.parseInt(st.nextToken());
                graph[i] = new Node(k, graph[i]);
            }
        }
    }

    static void comb(int index, boolean[] selected){
        if(index == n+1){
            boolean[] visited = new boolean[n+1];
            int red = 0;
            int blue = 0;
            int k = 0;
            for(int i = 1; i<= n; i++){
                if(!selected[i]) continue;

                // select 된 애들 중에서~
                //
                if(visited[i]) continue;
                red += bfs(i, visited, true, selected);
                k++;

            }

            for(int i = 1; i<= n; i++){
                if(selected[i]) continue;

                // select 된 애들 중에서~
                //
                if(visited[i]) continue;
                blue += bfs(i, visited, false, selected);
                k++;

            }

//            System.out.println(Arrays.toString(selected));
//            System.out.println(k + " " + red + " " + blue);


            if(k == 2){
                min = Math.min(min, Math.abs(blue-red));
            }

            return;
        }

        for(int i = index; i<=n; i++){
            selected[i] = true;
            comb(i+1, selected);
            selected[i] = false;
        }
    }

    static int bfs(int k, boolean[] visited, boolean redOrBlue, boolean[] selected){
        Queue<Integer> q = new ArrayDeque<>();
        visited[k] = true;
        q.add(k);
        int total = 0;
        total += numberOfCitizen[k];

        while(!q.isEmpty()){
            int c = q.poll();


            for(Node n = graph[c]; n != null; n = n.next){
                if(selected[n.to] != redOrBlue) continue;
                if(visited[n.to]) continue;
                q.add(n.to);
                visited[n.to] = true;
                total += numberOfCitizen[n.to];
            }

        }

        return total;
    }

    static class Node{

        int to;
        Node next;

        public Node(int to, Node next){

            this.to = to;
            this.next = next;

        }
    }
}
