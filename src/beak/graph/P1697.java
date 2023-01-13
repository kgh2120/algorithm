package beak.graph;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class P1697 {


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

    public static void main(String[] args) throws Exception {
        new P1697().solution();
    }
}





