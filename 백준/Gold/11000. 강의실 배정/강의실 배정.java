import java.util.*;
import java.io.*;

/*
    강의의 시작시간에는 강의실을 사용해야함.
    강의 시작순으로 정렬을 하고, 새로운 강의실을 넣을 때엔
    PQ에 끝나는 시간이 빠른 순으로 정렬을 박아서 
    새로운 강의 시작시간 >= 끝나는 강의 시간이면
    끝강의를 poll 박아주고 (반복문 박아야함)
    아니면 add를 해준다.
    이때 사용되는 강의실의 최대값(pq의size)을 max값으로 기록해놓으면 될 듯 하다.

*/

public class Main {
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        PScanner sc = new PScanner(System.in);
        int n = sc.nextInt();

        Queue<Node> startQueue= new PriorityQueue<>();
        Queue<Node> endQueue= new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                int v = Integer.compare(o1.end, o2.end);
                if(v == 0)
                    return Integer.compare(o1.start, o2.start);
                return v;
            }
        });
        for(int i = 0;i<n;i++){
            startQueue.add(new Node(sc.nextInt(), sc.nextInt()));
        }

        int max = -1;
        while(!startQueue.isEmpty()){
            Node node = startQueue.poll();
            while(!endQueue.isEmpty() && endQueue.peek().end <= node.start){
                endQueue.poll();
            }
            endQueue.add(node);
            max = Math.max(max, endQueue.size());
        }

        System.out.println(max);



    }

    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int s, int e){
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Node o){
            int v = Integer.compare(this.start, o.start);
            if(v == 0)
                return Integer.compare(this.end, o.end);
            return v;
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