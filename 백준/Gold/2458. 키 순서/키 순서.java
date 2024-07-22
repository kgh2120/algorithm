import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] in = new int[n+1];
        int[] out = new int[n+1];
        Edge[] down = new Edge[n + 1];
        Edge[] up = new Edge[n + 1];
        Student[] students = new Student[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            students[i] = new Student(n);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            in[t]++;
            out[f]++;
            down[f] = new Edge(t, down[f]);
            up[t] = new Edge(f, up[t]);
            students[f].up[t] = true;
        }

        Queue<Integer> inque = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            if(in[i] == 0)
                inque.add(i);
        }


        // 진행하기

        while(!inque.isEmpty()) {
            Integer poll = inque.poll();
            // poll의 next들에게 전달하기
            for(Edge e = down[poll]; e != null; e = e.next) {
                if(--in[e.to] == 0) {
                    inque.add(e.to);
                }
                students[e.to].down(poll, students[poll].down);
            }
        }

        Queue<Integer> outQueue = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            if(out[i] == 0)
                outQueue.add(i);
        }

        // 진행하기

        while(!outQueue.isEmpty()) {
            Integer poll = outQueue.poll();
            // poll의 next들에게 전달하기
            for(Edge e = up[poll]; e != null; e = e.next) {
                if(--out[e.to] == 0) {
                    outQueue.add(e.to);
                }
                students[e.to].up(students[poll].up);
            }
        }




        for (int i = 1; i <= n ; i++) {
            if (students[i].isKnown(n)) {
                answer++;
            }
        }
        System.out.println(answer);



    }

    static class Student{
        boolean [] up;
        boolean [] down;

        public Student(int n) {
            up = new boolean[n+1];
            down = new boolean[n+1];
        }

        public void up(boolean [] targetUp) {
            for (int i = 1; i <= down.length -1 ; i++) {
                if(targetUp[i]){
                    up[i] = true;
                }
            }
        }

        public void down(int index, boolean [] targetDown){
            this.down[index] = true;
            for (int i = 1; i <= down.length -1 ; i++) {
                if(targetDown[i]){
                    down[i] = true;
                }
            }
        }

        public boolean isKnown(int n){
            int cnt = 0;
            for (int i = 1; i <= n ; i++) {
                if(up[i])
                    cnt++;
                if(down[i])
                    cnt++;
            }
            return cnt+1 == n;
        }
    }

    static class Edge{
        int to;
        Edge next;

        public Edge(int to, Edge next) {
            this.to = to;
            this.next = next;
        }
    }



}