import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static Edge[] graph;
    static boolean [] visited;


    public static void main(String[] args) throws Exception{
        PScanner sc = new PScanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();


            graph = new Edge[n+1];
            visited = new boolean[n+1];

            for(int j = 0; j<m; j++){

                int a = sc.nextInt();
                int b = sc.nextInt();
                int cost = sc.nextInt();
                graph[a] = new Edge(b, cost, graph[a]);
                graph[b] = new Edge(a, cost, graph[b]);

            }
            visited[1] = true;
            int cost = 0;
            if(m != 0)
             cost = dfs(1);
            sb.append(cost).append("\n");

        }
        System.out.println(sb);


    }

    static int dfs(int i) {
        boolean isLeafNode = true;
        int cost = 0;
        for (Edge e = graph[i]; e != null; e = e.next) {
            if(visited[e.to]) continue;
            isLeafNode = false;
            visited[e.to] = true;
            int dfs = dfs(e.to);
            int value = Math.min(e.cost, dfs);
            cost += value;
        }

        if(isLeafNode) return graph[i].cost;


        return cost;
    }

    static class Edge{
        int to;
        int cost;
        Edge next;

        public Edge(int to, int cost, Edge next) {
            this.to = to;
            this.cost = cost;
            this.next = next;
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