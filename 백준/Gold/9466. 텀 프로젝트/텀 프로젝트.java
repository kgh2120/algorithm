import java.util.*;
import java.io.*;
public class Main {

    static int[] arr;
    static int answer;

    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            answer = 0;
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished= new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                makeTeam(i);
            }
            sb.append(n-answer).append("\n");


        }
        System.out.println(sb);
    }
    private static void makeTeam(int n){


        if(visited[n]){
            if(finished[n]) return;
            finished[n] = true;
            answer++;
            makeTeam(arr[n]);
            return;
        }
        visited[n] = true;
        if(finished[n]) return;
        makeTeam(arr[n]);
        finished[n] = true;

    }

}
