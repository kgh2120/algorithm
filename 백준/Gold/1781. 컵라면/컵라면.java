import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        PScanner sc = new PScanner(System.in);
        int n = sc.nextInt();

        Queue<Problem> pq = new PriorityQueue<>();
        Queue<Problem> problems = new PriorityQueue<>(new Comparator<Problem>(){
            @Override
            public int compare(Problem p1, Problem p2){
                return Integer.compare(p1.deadLine, p2.deadLine) * -1;
            }
        });
        int max = -1;

        for(int i = 0; i<n; i++){
            
            int dead = sc.nextInt();
            int value = sc.nextInt();

            Problem problem = new Problem(dead,value);
            problems.add(problem);
            max = Math.max(dead, max);
        }



        int answer = 0;
        while(max != 0){
            while(!problems.isEmpty()  && problems.peek().deadLine == max){
                pq.add(problems.poll());
            }

            max--;
            if(pq.isEmpty()){
                continue;
            }
            Problem problem = pq.poll();
            answer += problem.value;
        }
        System.out.println(answer);

    }

    static class Problem implements Comparable<Problem>{
        int deadLine;
        int value;

        public Problem(int d, int v){
            this.deadLine = d;
            this.value = v;
        }

        @Override
        public int compareTo(Problem o){
            return Integer.compare(value, o.value) * -1;
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