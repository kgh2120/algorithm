import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        Deque<Node> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.peekLast().value < number) {
                Node node = deque.pollLast();
                arr[node.index] = number;
            }
            deque.addLast(new Node(number, i));
        }


        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }


}