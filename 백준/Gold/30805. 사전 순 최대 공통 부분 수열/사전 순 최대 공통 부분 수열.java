import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 : 1초 1024mb
    @입력 범위 : 1<= n,m <= 100, 1<= 각 배열의 값 <= 100
    @문제 내용 :
        배열A와 배열 B의 공통 부분 수열을 구하고, 각 공통 부분 수열 중에서 사전순 정렬이 가장 늦은 친구를 찾자.
    @주의 사항 : n과m이 작긴 한데, 1초 안에 될지 잘 모르겠다.
    @예상 알고리즘 : 공통 부분 수열,  정렬?
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] a;
    static int m;
    static int [] b;

    static Queue<Node> pq = new PriorityQueue<>();
    static String[][] dp;

    public static void main(String[] args) throws Exception {





        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            int k = a[i];
            for (int jj = 0; jj<m; jj++) {
                if (k == b[jj]) {
                    pq.add(new Node(k, i, jj));
                }
            }
        }


        int size = 0;
        StringBuilder sb = new StringBuilder();
        int aLastIndex = Integer.MIN_VALUE;
        int bLastIndex = Integer.MIN_VALUE;
        boolean[] visited = new boolean[m];
        // lastIndex보다 더 작은 애는 못들어감
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if(aLastIndex >= node.aIndex || bLastIndex >= node.bIndex  || visited[node.bIndex]) continue;
//            System.out.println(node);
            visited[node.bIndex] = true;
            sb.append(node.value).append(" ");
            size++;
            aLastIndex = node.aIndex;
            bLastIndex = node.bIndex;
        }
        if (size == 0) {
            System.out.println(0);
        }else {
            System.out.println(size);
            System.out.println(sb);
        }
    }

    static class Node implements Comparable<Node>{
        int value;
        int aIndex;
        int bIndex;

        public Node(int value, int aIndex, int bIndex) {
            this.value = value;
            this.aIndex = aIndex;
            this.bIndex = bIndex;
        }

        @Override
        public int compareTo(Node o) {

            int i = Integer.compare(this.value, o.value) * -1;
            if (i == 0) {
                int compare = Integer.compare(this.aIndex, o.aIndex);
                if (compare == 0) {
                    return Integer.compare(this.bIndex, o.bIndex);
                }
                return compare;
            }
            return i;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", aIndex=" + aIndex +
                    ", bIndex=" + bIndex +
                    '}';
        }
    }




}