import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제한 사항 : 0.5s, 128MB
 * 문제 내용 :
 * N개의 도시에서 도시 X -> 도시 Y로 가는 M개의 버스가 있다고 한다.
 * 이 중에서 도시 A -> 도시 B로 가는 최소한의 버스 비용을 구하라고 한다.
 * 아마도 다익스트라일 가능성이 높지 않을까 싶다.
 *
 * N -> 1 <= N <= 1000
 * M -> 1 <= M <= 100_000
 * 버스 비용 C는 0 <= C <= 100_000
 * 최대 나올 수 있는 비용 : N * C => 100_000_000 / 10^8 1억 int 범위 내에서 해결 가능함.
 */

public class Main {


//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
    

    public static void main(String[] args) throws Exception {
        PScanner sc = new PScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        final int INIT = 10_0000_0000;

        Edge[] edges = new Edge[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INIT);

        for (int i = 0; i < m; i++) {
            
            int from = sc.nextInt();
            int to  = sc.nextInt();
            int cost = sc.nextInt();
            edges[from] = new Edge(to, cost, edges[from]);

        }

        
        int a = sc.nextInt();
        int b = sc.nextInt();

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(a, 0, null));
        dist[a] = 0 ;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if(dist[edge.to] < edge.cost) continue;

            for(Edge e = edges[edge.to]; e != null; e = e.next) {
                if (dist[e.to] > e.cost + edge.cost) {
                    dist[e.to] = e.cost + edge.cost;
                    pq.add(new Edge(e.to, dist[e.to], null));
                }
            }
        }
        System.out.println(dist[b]);





    }

    static class Edge implements Comparable<Edge> {
        int to;
        int cost;
        Edge next;

        public Edge(int to, int cost, Edge next) {
            this.to = to;
            this.cost = cost;
            this.next = next;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
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