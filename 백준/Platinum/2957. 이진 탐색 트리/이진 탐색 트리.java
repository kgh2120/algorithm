import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();



    public static void main(String[] args) throws Exception {

        TreeMap<Integer, Node> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());

        int root = Integer.parseInt(br.readLine());

        map.put(root, new Node(0));
        long c = 0;
        answer.append(c).append("\n");
        for (int i = 1; i < n; i++) {


            int k = Integer.parseInt(br.readLine());

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
}
