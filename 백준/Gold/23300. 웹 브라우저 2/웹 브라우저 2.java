import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // B F A C

    static Node backStack;
    static Node frontStack;
    static int cur = -1;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            action(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cur).append("\n");
        printQueue(sb, backStack);
        printQueue(sb, frontStack);

        System.out.println(sb);

    }

    private static void printQueue(StringBuilder sb, Node node) {
        if(node == null){
            sb.append(-1);
        }else {
            while (node != null) {
                while(node.count-->0)
                    sb.append(node.pageNumber).append(" ");
                node = node.next;
            }
        }
        sb.append("\n");
    }

    static void action(String command){
        StringTokenizer st = new StringTokenizer(command);

        switch (st.nextToken()) {
            case "B":
                    if(backStack != null){
                        frontStack = new Node(cur, frontStack);
                        cur = backStack.pageNumber;
                        if (--backStack.count == 0) {
                            backStack = backStack.next;
                        }
                    }
                break;
            case "F":
                    if(frontStack != null){
                        if(backStack != null && backStack.pageNumber == cur){
                            backStack.count++;
                        }else {
                            backStack = new Node(cur, backStack);
                        }
                        cur = frontStack.pageNumber;
                        frontStack = frontStack.next;
                       
                    }
                break;
            case "A":
                frontStack = null;
                if (cur != -1) {
                    if(backStack != null && backStack.pageNumber == cur){
                        backStack.count++;
                    }else {
                        backStack = new Node(cur, backStack);
                    }
                }
                cur = Integer.parseInt(st.nextToken());
                break;
            case "C":
                Node temp = backStack;
                while (temp != null) {
                    temp.count = 1;
                    temp = temp.next;
                }
                break;
        }
    }

    static class Node{
        int pageNumber;
        int count;
        Node next;

        public Node(int pageNumber,  Node next) {
            this.pageNumber = pageNumber;
            this.count = 1;
            this.next = next;
        }
    }
}