package Inflearn.recursiveBFSDFS;
public class Inflearn_7_5_traverse_node{

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    static Node root;

    public static void main(String[] args) {

        // 관계 형성.
        Node[] nodes = new Node[8];

        for (int i = 1; i < 8; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < 8; i++) {
            if(2*i >= 8 ) continue;
            nodes[i].left = nodes[2*i];
            nodes[i].right = nodes[2*i +1];
        }

        root = nodes[1];
        preOrder();
        inOrder();
        postOrder();

    }

    public static void preOrder() {
        System.out.println();
        System.out.println("<< PreOrder - Traverse >> ");
        preOrder(root);
    }

    public static void inOrder() {
        System.out.println();
        System.out.println("<< InOrder - Traverse >> ");
        inOrder(root);
    }

    public static void postOrder() {
        System.out.println();
        System.out.println("<< PostOrder - Traverse >> ");
        postOrder(root);
    }

    public static void preOrder(Node node) {
        if(node==null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);


    }

    public static void inOrder(Node node) {
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);

    }

    public static void postOrder(Node node) {
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");

    }
}

