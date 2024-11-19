import java.util.*;
import java.io.*;

/**
    
    
    추가 테케
    
    치즈가 하나도 없는 경우
    3 3
    0 0 0
    0 0 0
    0 0 0
    
    답 0
    
    치즈 1개 있는 경우
    3 3
    0 0 0
    0 1 0
    0 0 0
    
    답 1
    
**/
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] matrix;
    static int n;
    static int m;
    static int cheeseCount;
    static Queue<int[]> melted = new ArrayDeque<>();
    
    static int[][] deltas = {{-1,0}, {0,-1},{1,0},{0,1}};
    
    static final int CHEESE = 1;
    static final int BLANK = 0;
    
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        init();
        int answer = solution();
        System.out.println(answer);
        
    }
    
    static int solution(){
        
        int time = 0;
        while(cheeseCount != 0){
            // 녹을 애 찾기
            findOutterCheese();
            // 녹이기
            melt();
            time++;
        }
        return time;
    }
    
    static void findOutterCheese(){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            
            
            for(int [] delta : deltas){
                int nextRow = current[0] + delta[0];
                int nextCol = current[1] + delta[1];
                
                if(isIn(nextRow, nextCol)){
                    // 치즈인지 아닌지
                    if(matrix[nextRow][nextCol] == CHEESE){
                        if(++visited[nextRow][nextCol] == 2){
                            melted.add(new int[]{nextRow,nextCol});
                        }
                    }
                    else {
                        if(++visited[nextRow][nextCol] == 1)
                            q.add(new int[]{nextRow, nextCol});    
                    }
                    
                }
            }
            
        }
    }
    
    static void melt(){
    
        while(!melted.isEmpty()){
            int[] cheese = melted.poll();
            matrix[cheese[0]][cheese[1]] = BLANK;
            cheeseCount--;
        }
    }
    
    static boolean isIn(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    
    static void init() throws Exception{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        matrix = new int[n][m];
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                int block = Integer.parseInt(st.nextToken());
                matrix[i][j] = block;
                if(block == CHEESE){
                    cheeseCount++;
                }       
            }
        }
    }
}
