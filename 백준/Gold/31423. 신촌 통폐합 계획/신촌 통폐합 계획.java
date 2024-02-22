import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[n+1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(br.readLine());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int fromIndex = Integer.parseInt(st.nextToken());
            int toIndex = Integer.parseInt(st.nextToken());


            if(nodes[fromIndex] == null || nodes[toIndex] == null) continue;
            Node from = nodes[fromIndex];
            Node to = nodes[toIndex];

            if (from.tail == null) {
                if (to.tail == null) {
                    from.tail = to;
                    from.next = to;
                }else{
                    from.tail = to.tail;
                    from.next = to;
                }
            }else{
                Node tail = from.tail;
                if (to.tail == null) {
                    tail.next = to;
                    from.tail = to;
                }else{
                    tail.next = to;
                    from.tail = to.tail;
                }
            }
            nodes[toIndex] = null;
        }

        int index;
        for (index = 0; index < n; index++) {
            if(nodes[index] != null)
                break;
        }


//        System.out.println(Arrays.toString(nodes));

        for(Node node = nodes[index]; node != null; node = node.next)
            sb.append(node.value);

        System.out.println(sb);

    }


    static class Node{
        String value;
        Node next;
        Node tail;
        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    ", tail=" + tail +
                    '}';
        }
    }


}