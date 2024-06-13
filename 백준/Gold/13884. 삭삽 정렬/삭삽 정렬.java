import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfTestCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= nOfTestCase; t++) {
            st = new StringTokenizer(br.readLine());
            int problemIndex = Integer.parseInt(st.nextToken());
            int arrayLength = Integer.parseInt(st.nextToken());
            Queue<Node> pq = new PriorityQueue<>();

            int index = 0;

            int n = arrayLength/10 + 1;
            if(arrayLength > 0 && arrayLength%10 == 0)
                n--;

            for (int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                while(index < arrayLength && st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    pq.add(new Node(index, num));
                    index++;
                }
            }
            // 이제 정렬 진행
            int j = 0;

            int lastIndex =  -1;
            int lastValue = -1;
            boolean flag = false;
            while(!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.index > lastIndex) {
                    if(flag && lastValue < node.value)
                        break;
                    lastIndex = node.index;
                    lastValue = node.value;
                    j++;
                }
                else if (node.index < lastIndex && node.value >= lastValue) {
                    lastValue = node.value;
                    flag = true;
                    continue;
                }
                else {
                    break;
                }

            }
//            System.out.println(problemIndex + " " + j);
            sb.append(problemIndex).append(" ").append(arrayLength - j).append("\n");
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            int result = Integer.compare(this.value, o.value);
            if (result == 0) {
                return Integer.compare(this.index, o.index);
            }
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}