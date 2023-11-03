import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/1753
 * @since 2023-10-13
 **/
public class Main {
    static class Node implements Comparable<Node>{
        int idx;
        int weight;

        Node next;
        public Node(int idx, int weight, Node next) {
            this.idx = idx;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
    static int V,E,K;
    static Node[] graph;
    //인접 리스트
    static int[] answer;
    public static void main(String[] args) throws IOException {
        PScanner sc = new PScanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        K = sc.nextInt();
        graph = new Node[V+1];
        answer = new int[V + 1];
        Arrays.fill(answer,Integer.MAX_VALUE);
        for(int i=0;i<E;i++){

            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start] = new Node(end, weight, graph[start]);
        }
        // 단방향 그래프
        answer[K] = 0;
        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<V + 1;i++){
            String info = answer[i] == Integer.MAX_VALUE ? "INF" : String.valueOf(answer[i]);
            sb.append(info).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(){
        Queue<Node> que = new PriorityQueue<>();
        que.add(new Node(K,0, null));
        while(!que.isEmpty()){
            Node curr = que.poll();
            if(answer[curr.idx] < curr.weight) continue;
            for(Node node=graph[curr.idx]; node != null; node = node.next){
                if (answer[node.idx] > answer[curr.idx] + node.weight) {
                    answer[node.idx] = answer[curr.idx] + node.weight;
                    que.add(new Node(node.idx,node.weight + curr.weight, null));
                }
            }
        }
    }
    static class PScanner{private final InputStreamReader in;private final char[]buf;private int len,ptr;public PScanner(
                InputStream input){in=new InputStreamReader(input);buf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=new char[16];char clen=0;while((cbuf[clen++]=read())>' '){if(clen==cbuf.length)cbuf=Arrays.copyOf(cbuf,clen << 2);}return new String(cbuf,0,clen - 1);}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(
                IOException e){throw new RuntimeException(e.getMessage());}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
}