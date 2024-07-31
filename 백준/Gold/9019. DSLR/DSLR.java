import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 : 6s, 256mb
    @입력 범위 : 0 <= A,B < 10000
    @문제 내용 :
        4개의 명령을 수행하는 레지스터가 있음. 이 레지스터에 저장된 값을 4개의 명령을 수행하면서 A라는 값을 B로 바꾸는 최소한의 명령을 찾는 것이다.
        4개의 명령은 아래와 같다.
        D : if( n *=2 > 9999) n %= 10000
        S : if(--n == 0 ) n = 9999
        L : rotate left
        R : rotate right
    @주의 사항 :
        0이 끼어있는 경우 문자를 숫자로 바꾸면 0이 사라지게 됨. 하지만 명령을 수행할 때엔 0의 존재를 잊으면 곤란함.
    @예상 알고리즘 : BFS + 경로추적
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] visited;
    static Queue<Node> q;
    static int a;
    static int b;
    static int [] c = {0,1,2,3};
    

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            visited = new int[10_000][2];
            for (int j = 0; j < 10_000; j++) {
                visited[j][0] = -1;
            }
            q = new ArrayDeque<>();

            q.add(new Node(a));
            visited[a][0] = a;



            loop: while(!q.isEmpty()) {
                Node node = q.poll();
                for (int cc : c) {

                    Node next = node.command(cc);

                    if(visited[next.value][0] != -1) continue;
                    visited[next.value][0] = node.value;
                    visited[next.value][1] = cc;
                    q.add(next);
                    if (next.value == b) {
                        break loop;
                    }
                }

            }

            // b부터 찾아.
            StringBuilder sub = new StringBuilder();
            int cur = b;
            while (cur != a) {
                sub.append(convert(visited[cur][1]));
                cur = visited[cur][0];
            }
            sb.append(sub.reverse()).append("\n");
        }
        System.out.println(sb);
    }

    static char convert(int v){
        switch (v) {
            case 0: return 'D';
            case 1 : return 'S';
            case 2 : return 'L';
            case 3 :
                return 'R';
            default: return ' ';
        }
    }

    static class Node{

        int value;
        int d1;
        int d2;
        int d3;
        int d4;

        public Node(int d1, int d2, int d3, int d4){
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
            this.d4 = d4;
            value = d1 * 1000 + d2 * 100 + d3 * 10 + d4;
        }

        public Node(int value) {
            this.value = value;
            d1 = value / 1000;
            d2 = (value % 1000) / 100;
            d3 = (value % 100) / 10;
            d4 = value % 10;
        }

        public Node command(int command) {
            switch (command) {
                case 0 : return d();
                case 1 : return s();
                case 2 : return l();
                case 3 : return r();
                default: return null;
            }
        }

        public Node d(){
            int temp = value * 2;
            int v = temp > 9999 ? temp % 10000 : temp;
            return new Node(v);
        }

        public Node s(){
            int temp = value -1;
            int v = value == 0 ? 9999 : temp;
            return new Node(v);
        }

        public Node l(){
            return new Node(d2,d3,d4,d1);
        }
        public Node r(){
            return new Node(d4,d1,d2,d3);
        }

    }

}