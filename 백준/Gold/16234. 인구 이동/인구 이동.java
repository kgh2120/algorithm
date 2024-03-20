import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] deltas = {
        {-1,0},
        {0,1},
        {1,0},
        {0,-1}
    };

    static int n;
    static int L;
    static int R;

    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[n][n];


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }


        int days = 0;
        visited = new boolean[n][n];
        Queue<Union> q = new ArrayDeque<>();
        while(true){
            resetVisited();
                
            // 각 나라별 인구 이동 드가자
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(visited[i][j]) continue;
                    // bfs 돌기
                    Union union = bfs(i,j);
                    if(union.nOfCountry != 1){
                        q.add(union);
                    }
                }
            }

            if(q.isEmpty())
                break;
            
            move(q);
            days++;
            
        }
        System.out.println(days);
        
    }

    static void move(Queue<Union> q){
        while(!q.isEmpty()){
            Union u = q.poll();
            int value = u.totalCount / u.nOfCountry;
            for(Node n = u.node; n != null; n = n.next){
                map[n.row][n.col] = value;
            }
            
        }
    }

    static Union bfs(int row, int col){


        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row,col});
        visited[row][col] = true;
        Node node = null;
        node = new Node(row,col,node);
        int totalPeople = map[row][col];
        int nOfCountry = 1;

        while(!q.isEmpty()){

            int[] coord = q.poll();
            
            for(int[] delta : deltas){
                int nr = coord[0] + delta[0];
                int nc = coord[1] + delta[1];

                if(isIn(nr,nc) && !visited[nr][nc] && canUnion(coord[0], coord[1], nr , nc)){
                    visited[nr][nc] = true;
                    node = new Node(nr,nc,node);
                    q.add(new int[]{nr,nc});
                    totalPeople += map[nr][nc];
                    nOfCountry++;
                }
            }
        }
        return new Union(totalPeople, nOfCountry, node);
    }

    static boolean canUnion(int row, int col, int nr, int nc){
        int diff = Math.abs(map[row][col] - map[nr][nc]);
        return diff >= L && diff <= R;
    }

    static void resetVisited(){
        for(boolean[] visit : visited)
            Arrays.fill(visit, false);
    }

    static boolean isIn(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    static class Union{
        int totalCount;
        int nOfCountry;
        Node node;

        Union(int t, int c, Node n){
            totalCount = t;
            nOfCountry = c;
            node = n;
        }
    }
    static class Node{
        int row;
        int col;
        Node next;

        Node(int r, int c, Node n){
            row = r;
            col = c;
            next = n;
        }
    }
    
}