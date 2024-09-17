import java.util.*;
import java.io.*;

/*

    
    그냥 그래프를 전부 이어가면서 도달할 수 있는지를 체크하면 될 것 같음.
    예시에 나온 E C B C D가 주어졌을 때, A-B, B-C, A-D, B-D, E-A를 모두 잇는다면
    
    E->C, B D ... 를 다 갈 수 있다는 말임.
    
    일단은 방향 그래프인지, 무향 그래프인지를 안알려줘서 조금 곤란함.
    아 근데 예제 풀이를 보면 무향 그래프라는 것을 알 수 있다.
    
    그냥 출발 지점에서 bfs하면서 도달할 수 있는 곳들이 순서에 포함되어 있으면 yes같기도 하고..
    아니면
    E C B C D 이 상황에서 E -> C를 가는 상황에서 b c d를 거친다면 문제가 될 수 있으려나? 상관없을거같은데
    
    

*/
public class Main {
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] matrix = new int[n+1][n+1];
        for(int i = 1; i<= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }        
        
        
        // 여기서 bfsㅏㄴ번
        boolean [] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        
        visited[start] = true;
        
        q.add(start);
        while(!q.isEmpty()){
            int poll = q.poll();
            
            for(int i = 1; i<= n; i++){
                if(matrix[poll][i] == 0 || visited[i] ||i == poll) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        
        String ans = "YES";
        for(int i = 1; i<m; i++){
            int city = Integer.parseInt(st.nextToken());
            if(!visited[city]){
                ans = "NO";
                break;
            }
        }
        System.out.println(ans);
        
        
    }
}
