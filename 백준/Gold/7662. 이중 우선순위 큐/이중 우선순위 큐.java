import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 : 6s 256mb
    @입력 범위 : k <= 100,0000 // -2^31 <= i <= 2^31 (int)
    @문제 내용 :

        이중 우선순위 큐라는 자료구조를 만든다.
        삽입 , 삭제 연산이 있고, 삭제에는 최대값 삭제와 최소값 삭제 연산이 있음.
        삽입 연산은 I n 으로 표현하고 삭제 연산은 D 1 (최대값) D 2(최소값)으로 구분된다.

        연산의 개수는 K로 최대 100만개까지 있다.
        저장되는 숫자는 -2^31 ~ 2^31로 int 범위이다.

        모든 연산을 한 후, 최대값과 최소값을 출력하는데, 다 비었을 경우는 EMPTY를 ㅜㅊㄹ력한다.

        2개의 PQ를 만든다고 하면, 최대값 PQ와 최소값 PQ에 동시에 저장된 경우에 한 PQ에 의해서 삭제가 되더라도, 다른 PQ에서는 유지될 수있음. 이를 값으로 나타내줘야 할 듯.
    @주의 사항 :
        **저장되는 숫자는 -2^31 ~ 2^31로 int 범위이다.**
        연산이 총 100만개이다.
        지금 PQ를 2개를 만들어서 사용하려고 하는데, 아주 기본적인 처리를 한다고 가정하면, n log n일텐데,, 100만개라..
        100만 -> 10^6이고.. log를 할 때 10^3이 10이다. 그럼 100. 10^8 정도가 나오는데 6초니까 가능할듯..?
    @예상 알고리즘 :
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Queue<Node> maxPQ = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.value, o2.value) * -1;
                }
            });
            Queue<Node> minPQ = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Integer.compare(o1.value, o2.value);
                }
            });


            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if ("I".equals(command)) {
                    Node node = new Node(value);
                    maxPQ.add(node);
                    minPQ.add(node);
                } else if (value == 1) {
                    while (!maxPQ.isEmpty() && maxPQ.peek().isDeleted) {
                        maxPQ.poll();
                    }
                    if (!maxPQ.isEmpty()) {
                        maxPQ.poll().isDeleted = true;
                    }
                } else {
                    while (!minPQ.isEmpty() && minPQ.peek().isDeleted) {
                        minPQ.poll();
                    }
                    if (!minPQ.isEmpty()) {
                        minPQ.poll().isDeleted = true;
                    }
                }
            }
            while (!maxPQ.isEmpty() && maxPQ.peek().isDeleted) {
                maxPQ.poll();
            }
            while (!minPQ.isEmpty() && minPQ.peek().isDeleted) {
                minPQ.poll();
            }

            if (maxPQ.isEmpty() && minPQ.isEmpty()) {
                sb.append("EMPTY\n");
            }else {
                sb.append(maxPQ.poll().value).append(" ").append(minPQ.poll().value).append("\n");
            }



        }
        System.out.println(sb);

    }

    static class Node {
        int value;
        boolean isDeleted;

        public Node(int value) {
            this.value = value;
        }
    }
}