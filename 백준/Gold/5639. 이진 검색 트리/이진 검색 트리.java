import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Node root;
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str;
        Node cursor = null;
        // BST 구성하기
        while ((str = br.readLine()) != null) {

            int value = Integer.parseInt(str);
            add(value);
        }

        postOrderTraverse(root);

        System.out.println(sb);
    }

    static void add(int v){

        if (root == null) {
            root = new Node(v);
            return;
        }
        add(v, root);
    }
    static Node add(int v, Node n) {
        if (n == null) {
            return new Node(v);
        }

        if (v < n.value) {
            n.left = add(v, n.left);
        }

        else if(v > n.value) {
            n.right = add(v, n.right);
        }

        return n;
    }

    static void postOrderTraverse(Node root){
        if(root == null) return;
        // 좌, 우, 나.
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        sb.append(root.value).append("\n");

    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


}