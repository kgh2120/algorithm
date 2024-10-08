/*

    문자열이 주어진다. 문자열에 '폭발 문자열'이라는 것이 있으면, 폭발한다.

    폭발동작은 다음과 같다.
    1. 한 문자열 내에 폭발 문자열이 있다면 모두 사라진다.
    2. 새로운 문자열이 생성된다.
    1~2번 과정을 폭발 문자열이 없을때까지 반복한다.

    주의할 점은 새로운 문자열이 생성되면서 폭발 문자열이 새로 등장할 수 있다는 점이다.

    폭발 문자열이 더이상 없다면 그 상태의 문자열을 출력한다.
    하지만 모든 문자열이 다 터진다면 'FRULA'라는 단어를 출력한다.

    초기 문자열의 길이는 1<= L <= 1_000_000 (10^6)

    간단하게 생각해서 선형 탐색으로 쭉 가는거로는 시간초과가 날 가능성이 높아보인다.

    생각나는 방법
    1. 첫번째엔 선형탐색을 진행한다. 이때 폭발된 문자열의 위치를 찾는다.
       새로 폭발할 문자열이 생긴다면, 어차피 이 근처니까, 그쯤에서 찾아보기.

    그런데 굳이 한번에 터뜨릴 필요가 있나? 그냥 투포인터처럼 하면 안되나? 그게 1번이랑 동일한듯?


*/

import java.util.*;
import java.io.*;

public class Main {

    static Node head;
    static Node cursor;
    static Node tail;
    static int size;

    static int targetLength;
    static char[] targetArray;

    static int index;
    static boolean isNext;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        PScanner sc = new PScanner(System.in);


        String word = sc.next();
        String target = sc.next();
        targetArray = target.toCharArray();

        // Node head;
        // Node cursor;
        // Node tail;

        targetLength = target.length();
        if (word.length() < targetLength) {
            System.out.println(word);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (targetLength == 1) {
            for(char c : word.toCharArray()) {
                if(c == target.charAt(0)) {
                    continue;
                }
                sb.append(c);
            }

        } else {
            while (index < word.length()) {
                char v = word.charAt(index++);
                // 일단 추가를 한다.
                build(v);
                // 그 다음에 비교 진행.
                if (size < targetLength) continue;
                // 아니면 액션
                action();
            }

            Node c = head;
            while (c != null) {
                sb.append(c.v);
                c = c.next;
            }

        }


        // 전설의 시작


        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }


    }

    static void action() {

        int cnt = 0;
        Node c = cursor;
        boolean flag = false;

        while (cnt < targetLength) {

            if (c.v != targetArray[cnt]) {
                flag = true;
                break;
            }
            c = c.next; // NPE가 터짐.
            cnt++;
        }

        if (flag) {
            cursor = cursor.next;
        } else {
            // cursor 부터 targetLength까지 삭제.
            // cursor는 targetLength -1 만큼 뒤로간다.

            size -= targetLength;
            if (cursor.prev != null) {
                tail = cursor.prev;
                tail.next = null;
                cnt = 0;
                while (cnt < targetLength - 1 && cursor.prev != null) {
                    cursor = cursor.prev;
                    cnt++;
                }
            } else {
                head = null;
                cursor = null;
                tail = null;
            }


        }
    }

    static void build(char v) {
        if (head == null) {
            head = new Node(v, null, null);
            tail = head;
            cursor = head;
        } else {
            tail.next = new Node(v, tail, null);
            tail = tail.next;
        }
        size++;
    }

    static class Node {
        char v;
        Node prev;
        Node next;

        public Node(char v, Node prev, Node next) {
            this.v = v;
            this.prev = prev;
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