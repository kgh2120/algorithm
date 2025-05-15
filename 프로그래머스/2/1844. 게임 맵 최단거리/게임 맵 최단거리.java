import java.util.*;
class Solution {
    
    int[][] deltas = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    int n;
    int m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        int turn = 0;
        while(!q.isEmpty()){
            turn++;
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                
                for(int [] delta : deltas){
                    
                    int nr = delta[0] + cur[0];
                    int nc = delta[1] + cur[1];
                    
                    if(isIn(nr,nc) && !visited[nr][nc] && maps[nr][nc] == 1){
                        visited[nr][nc] = true;
                        if(nr == n-1 && nc == m-1){
                            return turn+1;
                        }
                        q.add(new int[]{nr,nc});
                    }
                }
                
            }
        }
        
        return -1;
    }
    
    private boolean isIn(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}