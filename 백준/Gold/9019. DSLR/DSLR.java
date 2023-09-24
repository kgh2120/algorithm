import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[] commands = {'D', 'S', 'L', 'R'};
    static boolean[] visited;

    public static void main(String[] args) throws Exception {


        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            visited = new boolean[10001];
            Record record = (bfs(from, to)).record;
            StringBuilder temp = new StringBuilder();
            while (record != null) {
                temp.append(record.command);
                record = record.next;
            }
            sb.append(temp.reverse()).append("\n");
        }
        System.out.print(sb);
    }

    static Node bfs(int from, int to){
        Queue<Node> q = new ArrayDeque<>();
        Node start = new Node(from,null);

        q.add(start);
        while (!q.isEmpty()) {
            Node poll = q.poll();

            for (char command : commands) {
                int action = action(command, poll.d1, poll.d2, poll.d3, poll.d4, poll.value);
                if (!visited[action]) {
                    visited[action] = true;
                    Node node = new Node(action, new Record(command, poll.record));
                    if (action == to) {
                        return node;
                    }
                    q.add(node);
                }
            }
        }
        return null;
    }


    static int action(char command, int d1, int d2, int d3, int d4, int value) {

        switch (command) {
            case 'D':
                value = (value * 2 ) % 10000;
                break;
            case 'S':
                if(value == 0)
                    value = 9999;
                else value--;
                break;
            case 'L':
                value = d2*1000 + d3 * 100 + d4 * 10 + d1;
                break;
            case 'R':
                // 마지막을 앞으로 보내기
                value = d4*1000 + d1 * 100 + d2 * 10 + d3;
                break;
        }
        return value;
    }

    // 자리수 구하기
    private static int getN(int k){

        int i = 0;
        while ((k / 10) != 0) {
            i++;
            k = k/10;
        }
        return i;
    }




    static class Node {
        int d1;
        int d2;
        int d3;
        int d4;
        int value;
        Record record;

        public Node(int value, Record record) {
            this.d1 = value/1000;
            this.d2 = value/100 % 10;
            this.d3 = value/10 % 10;
            this.d4 = value % 10;
            this.value = value;
            this.record = record;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "d1=" + d1 +
                    ", d2=" + d2 +
                    ", d3=" + d3 +
                    ", d4=" + d4 +
                    ", value=" + value +
                    ", record=" + record +
                    '}';
        }
    }

    static class Record {

        char command;
        Record next;

        public Record(char command, Record next) {
            this.command = command;
            this.next = next;
        }


    }



}