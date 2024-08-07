import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 :
    @입력 범위 :
    @문제 내용 :
    @주의 사항 :
    @예상 알고리즘 :
*/
public class Main {


    static PScanner sc = new PScanner(System.in);
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] graph = new Edge[n+1];
        for (int i = 0; i < m; i++) {
         
            int from = sc.nextInt();
            int to =  sc.nextInt();
            int weight = sc.nextInt();
            graph[from] = new Edge(to, weight, graph[from]);

        }
        int [] dist = new int[n+1];
        int [] path = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

       
        int a = sc.nextInt();
        int b = sc.nextInt();

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0, null));
        dist[a] = 0;
        path[a] = -1;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(dist[edge.to] < edge.weight) continue;

            for(Edge e = graph[edge.to]; e != null; e = e.next) {
                if(dist[e.to] > dist[edge.to] + e.weight) {
                    dist[e.to] = dist[edge.to] + e.weight;
                    path[e.to] = edge.to;
                    pq.add(new Edge(e.to, dist[e.to], null));
                }
            }
        }

        sb.append(dist[b]).append("\n");


        int k = path[b];
        Deque<Integer> route = new ArrayDeque<>();
        route.addFirst(b);
        while (k != -1) {
            route.addFirst(k);
            k = path[k];
        }
        sb.append(route.size()).append("\n");
        while(!route.isEmpty()) {
            Integer r = route.pollFirst();
            sb.append(r).append(" ");
        }

        System.out.println(sb);

    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        Edge next;

        public Edge(int to, int weight, Edge next) {
            this.to = to;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
         public static class PScanner {
                     private final InputStreamReader in;
                     private final char[] buf;
                     private final char[] cbuf;
                     private int len, ptr;
         
                     public PScanner(InputStream input) {
                         in = new InputStreamReader(input);
                         buf = new char[8192];
                         cbuf = new char[8192];
                     }
         
                     public boolean hasNext() {
                         consume();
                         return ptr < len && buf[ptr] > ' ';
                     }
         
                     public boolean hasNextInLine() {
                         char c;
                         while ((c = read()) <= ' ' && c != 0 && c != '\n') ;
                         ptr--;
                         return ptr < len && buf[ptr] > ' ';
                     }
         
                     public String next() {
                         consume();
                         char[] cbuf = this.cbuf;
                         int clen = 0;
                         int start = ptr;
                         while (true) {
                             if (ptr < len) {
                                 if (buf[ptr++] <= ' ') {
                                     cbuf = copy(buf, start, cbuf, clen, ptr - start);
                                     clen += ptr - start;
                                     break;
                                 }
                             } else if (ptr == len) {
                                 cbuf = copy(buf, start, cbuf, clen, ptr - start);
                                 clen += ptr - start;
                                 fill();
                                 start = ptr;
                             } else break;
                         }
                         ptr--;
                         if (ptr < len) clen--;
                         return new String(cbuf, 0, clen);
                     }
         
                     private char[] copy(char[] src, int srcPos, char[] dest, int destPos, int length) {
                         if (dest.length < destPos + length) dest = Arrays.copyOf(dest, dest.length << 1);
                         System.arraycopy(src, srcPos, dest, destPos, length);
                         return dest;
                     }
         
                     public char nextChar() {
                         consume();
                         return read();
                     }
         
                     public int nextInt() {
                         consume();
                         int v = 0;
                         char c = read();
                         boolean neg = c == '-';
                         if (neg) c = read();
                         do {
                             v = v * 10 + c - '0';
                         } while ('0' <= (c = read()) && c <= '9');
                         ptr--;
                         return neg ? -v : v;
                     }
         
                     public long nextLong() {
                         consume();
                         long v = 0;
                         char c = read();
                         boolean neg = c == '-';
                         if (neg) c = read();
                         do {
                             v = v * 10 + c - '0';
                         } while ('0' <= (c = read()) && c <= '9');
                         ptr--;
                         return neg ? -v : v;
                     }
         
                     private char read() {
                         if (ptr == len) fill();
                         return ptr < len ? buf[ptr++] : 0;
                     }
         
                     private void fill() {
                         try {
                             len = in.read(buf);
                             ptr = 0;
                         } catch (IOException e) {
                             throw new RuntimeException(e);
                         }
                     }
         
                     private void consume() {
                         char c;
                         while ((c = read()) <= ' ' && c != 0) ;
                         ptr--;
                     }
                 }


}