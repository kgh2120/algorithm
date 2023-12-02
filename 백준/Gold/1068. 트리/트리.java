import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

 class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int nOfNode;
    static int root;
    static int deletedNodeIndex;
    static Node[] children;
    public static void main(String[] args) throws Exception {
        setVariables();

        // delete Node
        deleteNode();

        // find LeafNode
        System.out.println(findLeafNodes());

    }

     private static int findLeafNodes() {
        int nOfLeafNodes = 0;
         Queue<Integer> q = new ArrayDeque<>();
         q.add(root);
         while (!q.isEmpty()) {
             Integer nodeNumber = q.poll();
             if (nodeNumber == deletedNodeIndex) {
                 continue;
             }

             if (children[nodeNumber] == null) {
                 nOfLeafNodes++;
             } else {
                 boolean isLeaf = true;
                 for (Node next = children[nodeNumber]; next != null; next = next.next) {
                     if(next.num == deletedNodeIndex)
                         continue;
                     q.add(next.num);
                     isLeaf = false;
                 }
                 if (isLeaf) {
                     nOfLeafNodes++;
                 }
             }
         }
         return nOfLeafNodes;
     }

     private static void deleteNode() {
         children[deletedNodeIndex] = null;
     }

     private static void setVariables() throws IOException {
         nOfNode = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
         children = new Node[nOfNode];
         for (int i = 0; i < nOfNode; i++) {
             // i => number,
             int parent = Integer.parseInt(st.nextToken());

             if (parent == -1) {
                 root = i;
                 continue;
             }
             children[parent] = new Node(children[parent], i);
         }

         deletedNodeIndex = Integer.parseInt(br.readLine());
     }


     static class Node{
        Node next;
        int num;
        public Node(Node next, int num) {
            this.next = next;
            this.num = num;
        }
    }




}