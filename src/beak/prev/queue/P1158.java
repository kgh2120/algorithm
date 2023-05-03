package beak.prev.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1158 {

    class Node{
        int v;
        Node next;
        Node prev;

        public Node(int v, Node next, Node prev) {
            this.v = v;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Node prev = null;
        head = null;
        for (int i = 1; i <= n; i++) {
            Node node = new Node(i, null, prev);
            if(head == null)
                head = node;
            if(prev != null)
                prev.next = node;
            prev = node;
        }
        prev.next = head;
        head.prev = prev;



        remove(l,n);
    }

    public void remove(int l, int k){
        StringBuilder sb= new StringBuilder();
        Node n = head;
        sb.append("<");

        while (k != 0) {
            k--;
            int i = 1;
            Node p = n.prev;
            while (i != l) {
                p = n;
                n = n.next;
                i++;
            }
            n.next.prev = p;
            p.next = n.next;
            sb.append(n.v).append(", ");
            n = n.next;

        }

        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.println(sb);
    }




    public static void main(String[] args) throws Exception {
        new P1158().solution();
    }

}
