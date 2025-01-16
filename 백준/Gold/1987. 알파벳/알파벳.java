import java.util.*;
import java.io.*;
public class Main {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int maxRow;
    static int maxCol;
    
    static int [][] deltas = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    
    static char[][] map;    
    // 26
    

    
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        
        st = new StringTokenizer(input.readLine());
        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());
        
        map = new char[maxRow][];
        
        for(int i = 0; i<maxRow; i++){
            map[i] = input.readLine().toCharArray();
        }
        
        boolean[] selected = new boolean[26];
        selected[map[0][0] - 'A'] = true;
        int answer = dfs(0,0, selected);
        System.out.println(answer);

    }
    
    static int dfs(int row, int col, boolean[] selected){
        
        int max = 0;
        // 4방향 탐색
        for(int [] delta : deltas){
            int nr = row + delta[0];
            int nc = col + delta[1];
            
            if(isIn(nr,nc)){
                char next = map[nr][nc];
                if(!selected[next-'A']){
                    selected[next-'A'] = true;
                    max = Math.max(max, dfs(nr,nc, selected));
                    selected[next-'A'] = false;
                    
                }
            }
        }
        return 1 + max;
    }
    
    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }
}
