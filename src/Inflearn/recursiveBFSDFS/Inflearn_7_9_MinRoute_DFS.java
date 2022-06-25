package Inflearn.recursiveBFSDFS;

import java.util.HashMap;
import java.util.Map;

public class Inflearn_7_9_MinRoute_DFS {
    static Node root;
    static class Node{
        Node l, r;
        int val;
    }


    static Map<Integer, Node> ans = new HashMap<>();
    public static void main(String[] args) {

        Node n1 = new Node();

        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        n1.val = 1; n2.val = 2; n3.val = 3; n4.val = 4; n5.val = 5;
        n1.l = n2;
        n1.r = n3;
        n2.l = n4;
//        n2.r = n5;

        root = n1;
        DFS(root, 0);
        int min = Integer.MAX_VALUE;
        for (Integer d : ans.keySet()) {
            min = Math.min(d,min);
        }

        System.out.println("가장 짧은 길이의 노드는 " + ans.get(min).val + "번 노드까지의 길이인" + min + "이다.");


    }


    public static void DFS(Node n, int depth) {
        if (isLastNode(n)) {
            ans.put(depth, n);
            return;
        }
        depth++;
        if(n.l != null)
            DFS(n.l, depth);
        if(n.r != null)
            DFS(n.r,depth);
    }

    public static boolean isLastNode(Node n) {
        return n.l == null && n.r == null;
    }
}
