import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int [] road = new int[100001];

        bfs(road, s,b);
    }

    public void bfs(int[] road, int s, int b){
        int sec = 0;
        road[s] = sec;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            if (poll == b) {
                System.out.println(road[poll]);
                break;
            }

            // 뒤로1칸
            int back = poll-1;
            int front = poll+1;
            int telpo = poll*2;

            if (back == b || front == b || telpo == b) {
                System.out.println(road[poll] +1);
                break;
            }


            if (back >= 0 && road[back] == 0) {
                q.add(back);
                road[back] = road[poll] +1;
            }

            // 앞으로1칸

            if (front <= 100000 && road[front] == 0) {
                q.add(front);
                road[front] = road[poll] +1;
            }

            // 순간이동

            if (telpo <= 100000 && road[telpo] == 0) {
                q.add(telpo);
                road[telpo] = road[poll] +1;
            }



        }


    }

    public boolean move(Queue<Turn> q, Set<Integer> visited, Turn t, int b){

        if (t.position - 1 == b || t.position + 1 == b || t.position * 2 == b) {
            System.out.println(t.sec +1);
            return true;
        }

        if (!visited.contains(t.position - 1)) {
            q.add(new Turn(t.sec + 1, t.position - 1));
            visited.add(t.position-1);
        }
        if (!visited.contains(t.position + 1)) {
            q.add(new Turn(t.sec + 1, t.position + 1));
            visited.add(t.position+1);
        }
        if (!visited.contains(t.position * 2)) {
            q.add(new Turn(t.sec + 1, t.position * 2));
            visited.add(t.position*2);
        }

        return false;
    }


    class Turn{
        int sec;
        int position;

        public Turn(int sec, int position) {
            this.sec = sec;
            this.position = position;
        }
    }




    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}





