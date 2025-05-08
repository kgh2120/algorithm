import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;




    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int brother =  Integer.parseInt(st.nextToken());

        Queue<Location> q = new ArrayDeque<>();

        q.add(new Location(subin, 0));
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[100_001];
        visited[subin] = true;

        while(!q.isEmpty()){
            Location cur = q.poll();

            if (cur.value == brother) {
                min = Math.min(min, cur.time);
                continue;
            }

            if (cur.value > brother) {
                min = Math.min(min, cur.time + cur.value - brother);
                continue;
            }

            enqueue(q, visited, new Location(cur.value * 2, cur.time));
            enqueue(q, visited, new Location(cur.value-1, cur.time+1));
            enqueue(q, visited, new Location(cur.value+1, cur.time+1));

        }



        System.out.println(min);


    }

    private static void enqueue(Queue<Location> q, boolean[] visited, Location next){
        if(next.value < 0 || next.value >= visited.length) return;
        if(visited[next.value]) return;
        visited[next.value] = true;
        q.add(next);
    }

    static class Location{
        int value;
        int time;

        public Location(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }

}
