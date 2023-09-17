import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/*

    I a : pq에 a를 넣어라
    D 1 : 최대값 삭제
    D -1 최소값 삭제

    q가 비었는데 D 연산이 들어갈 경우 무시한다.

    연산이 끝났을 때 Q에 남아있는 최대값과 최소값을 출력한다.
 */
public class Main {


    public static void main(String[] args) {
        PScanner sc = new PScanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int nOfCommand = sc.nextInt();
            PriorityQueue<Node> minQ = new PriorityQueue<>(new Comparator<Node>(){

                @Override
                public int compare(Node node, Node t1) {

                    if (node.value == t1.value) {

                        if(!node.isOut)
                            return -1;
                        else
                            return 1;
                    }

                    return Integer.compare(node.value,t1.value);
                }
            });
            PriorityQueue<Node> maxQ = new PriorityQueue<>(new Comparator<Node>(){
                @Override
                public int compare(Node node, Node t1) {
                    if (node.value == t1.value) {
                        if(!node.isOut)
                            return -1;
                        else
                            return 1;
                    }
                    return Integer.compare(node.value,t1.value) * -1;
                }
            });

            for (int j = 0; j < nOfCommand; j++) {
                String command = sc.next();
                int number = sc.nextInt();
                if (command.equals("I")) {
                    Node node = new Node(number);
                    minQ.add(node);
                    maxQ.add(node);
                } else {
                    if (number == 1) {
                        // max값 빼기
                        poll(maxQ,false);
                    } else {
                        // min값 빼기
                        poll(minQ,false);
                    }
                }

            }

            
            
            // 최대값 최소값 찾기
            //일단 최대값

            long m = Long.MIN_VALUE;
            Node max = poll(maxQ, true);
            if (max != null) {
                m = max.value;
            }

            long n = Long.MIN_VALUE;
            Node min = poll(minQ, true);
            if (min != null) {
                n = min.value;
            }

            if (m == Long.MIN_VALUE && n == Long.MIN_VALUE) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(m).append(" ").append(n).append("\n");
            }


        }

        System.out.println(sb);




    }

    private static Node poll(PriorityQueue<Node> pq, boolean isLast){
        if (!pq.isEmpty()) {
            Node n = pq.poll();
            pq.add(n);
            n = pq.poll();
            while (!pq.isEmpty() && n.isOut) {
                n = pq.poll();
            }
            // 이미 삭제되지 않는 값밖에 없음.
            if(n.isOut) return null;
            // 아니라면 Node 반환
            if(!isLast)
                n.isOut = true;
            return n;
        }
        return null;
    }

    static class Node{

        int value;
        boolean isOut;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", isOut=" + isOut +
                    '}';
        }
    }

    static class PScanner{private final InputStreamReader in;private final char[]buf;private int len,ptr;public PScanner(
            InputStream input){in=new InputStreamReader(input);buf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=new char[16];char clen=0;while((cbuf[clen++]=read())>' '){if(clen==cbuf.length)cbuf= Arrays.copyOf(cbuf,clen << 2);}return new String(cbuf,0,clen - 1);}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(
            IOException e){throw new RuntimeException(e.getMessage());}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
}