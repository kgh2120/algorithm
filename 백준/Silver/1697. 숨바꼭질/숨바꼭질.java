import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        boolean [] visited = new boolean[100001];
        visited[n] = true;
        q.add(n);

        int turn = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size -- > 0){

                int cur = q.poll();
                if(cur == k){
                    System.out.println(turn);
                    return;
                }


                findPath(cur -1, visited, q);
                findPath(cur + 1, visited, q);
                findPath(cur * 2 , visited, q);


            }
            turn++;




        }

    }

    static void findPath(int nextStep, boolean [] visited, Queue<Integer> q){

        if(nextStep < 0 || nextStep >= visited.length || visited[nextStep]) return;
        q.add(nextStep);
        visited[nextStep] = true;


    }
}
