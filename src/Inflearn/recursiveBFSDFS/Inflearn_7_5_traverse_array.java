package Inflearn.recursiveBFSDFS;

public class Inflearn_7_5_traverse_array {
    static int[] binaryTree;

    public static void main(String[] args) {

        binaryTree = new int[8];
        for (int i = 1; i < binaryTree.length; i++) {
            binaryTree[i] = i;
        }
        preOrder();
        inOrder();
        postOrder();


    }

    public static void preOrder() {
        System.out.println();
        System.out.println("<< PreOrder - Traverse >> ");
        preOrder(1);
    }

    public static void inOrder() {
        System.out.println();
        System.out.println("<< InOrder - Traverse >> ");
        inOrder(1);
    }

    public static void postOrder() {
        System.out.println();
        System.out.println("<< PostOrder - Traverse >> ");
        postOrder(1);
    }

    private static void preOrder(int index) {
        if(index >= binaryTree.length) return;

        System.out.print(binaryTree[index] + " ");
        preOrder(index*2);
        preOrder(index*2 +1);

    }

    public static void inOrder(int index) {
        if(index >= binaryTree.length) return;

        inOrder(index*2);
        System.out.print(binaryTree[index] + " ");
        inOrder(index*2 +1);


    }



    public static void postOrder(int index) {
        if(index >= binaryTree.length) return;

        postOrder(index*2);
        postOrder(index*2 +1);
        System.out.print(binaryTree[index] + " ");
    }

}
