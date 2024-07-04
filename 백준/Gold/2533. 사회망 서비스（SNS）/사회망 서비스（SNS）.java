import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        PScanner sc = new PScanner(System.in);
        int n = sc.nextInt();
        int[] life = new int[n+1];
        Node[] graph = new Node[n + 1];
        boolean[] selected = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
        
            int left = sc.nextInt();
            int right = sc.nextInt();
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