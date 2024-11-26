import java.util.*;
import java.io.*;


public class Main {

    static PScanner sc = new PScanner(System.in);
    static StringBuilder answer = new StringBuilder();



    public static void main(String[] args) throws Exception {

        TreeMap<Integer, Node> map = new TreeMap<>();

        int n = sc.nextInt();

        int root = sc.nextInt();

        map.put(root, new Node(0));
        long c = 0;
        answer.append(c).append("\n");
        for (int i = 1; i < n; i++) {


            int k = sc.nextInt();

            Map.Entry<Integer, Node> lowerEntry = map.lowerEntry(k);
            Map.Entry<Integer, Node> higherEntry = map.higherEntry(k);

            int nextDepth;

            // higher만 있는 경
            if (lowerEntry == null) {

                Node higherNode = higherEntry.getValue();
                higherNode.hasLeft = true;
                nextDepth = higherNode.depth+1;
            } else if (higherEntry == null) { // lower만 있는 경우
                Node lowerNode = lowerEntry.getValue();
                lowerNode.hasRight = true;
                nextDepth = lowerNode.depth+1;
            } else {

                // 둘 다 있는 경우

                Node lNode = lowerEntry.getValue();
                Node rNode = higherEntry.getValue();

                if(lNode.hasRight && !rNode.hasLeft) {
                    rNode.hasLeft = true;
                    nextDepth = rNode.depth+1;
                } else {
                    lNode.hasRight = true;
                    nextDepth = lNode.depth+1;
                }
            }


            map.put(k, new Node(nextDepth));

            c += nextDepth;

            answer.append(c).append("\n");
        }
        System.out.println(answer);


    }

    static class Node{
        int depth;
        boolean hasLeft;
        boolean hasRight;

        public Node(int depth) {
            this.depth = depth;
        }
    }
        // @formatter:off
            static class PScanner{private final InputStreamReader in;private final char[]buf;private final char[]cbuf;private int len,ptr;public PScanner(InputStream input){in=new InputStreamReader(input);buf=new char[8192];cbuf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public boolean hasNextInLine(){char c;while((c=read())<=' '&&c!=0&&c!='\n');ptr--;return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=this.cbuf;int clen=0;int start=ptr;while(true){if(ptr<len){if(buf[ptr++]<=' '){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;break;}}else if(ptr==len){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;fill();start=ptr;}else break;}ptr--;if(ptr<len)clen--;return new String(cbuf,0,clen);}private char[]copy(char[]src,int srcPos,char[]dest,int destPos,int length){if(dest.length<destPos+length)dest=Arrays.copyOf(dest,dest.length << 1);System.arraycopy(src,srcPos,dest,destPos,length);return dest;}public char nextChar(){consume();return read();}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(IOException e){throw new RuntimeException(e);}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
}
