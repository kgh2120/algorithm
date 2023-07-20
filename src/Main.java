import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m,n,z;
    static int[][][]matrix;
    static int nOfTarget;
    static int last;
    static List<int[]> startPoints = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         m = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());
         z = Integer.parseInt(st.nextToken());

         matrix = new int[n][m][z];
         for(int i = 0; i<z; i++){
             for(int j = 0; j<n; j++){
                 st = new StringTokenizer(br.readLine());
                 for(int k = 0; k<m; k++){
                     int field = Integer.parseInt(st.nextToken());
                     matrix[j][k][i] = field;
                     if(field == 0)
                         nOfTarget++;
                     if(field == 1){
                         nOfTarget++;
                         startPoints.add(new int[]{j,k,i});
                     }
                 }
             }
         }

        System.out.println(bfs());


    }

    private static int bfs(){
        if(nOfTarget == startPoints.size())
            return 0;

        Queue<int[]> q = new LinkedList<>();
        for (int[] startPoint : startPoints) {
            q.add(startPoint);
        }

        int[][] deltas = {
                {1,0,0}, {-1,0,0},
                {0,1,0}, {0,-1,0},
                {0,0,1}, {0,0,-1}
        };

        while(!q.isEmpty()){
            int[] poll = q.poll();
            nOfTarget--;
            last = Math.max(last, matrix[poll[0]][poll[1]][poll[2]]);

            if(nOfTarget == 0)
                break;

            for (int[] delta : deltas) {
                if(poll[0] + delta[0] >=0 && poll[0] + delta[0] < n &&
                poll[1] + delta[1] >= 0 && poll[1] + delta[1] < m &&
                poll[2] +delta[2] >=0 && poll[2] + delta[2] < z &&
                matrix[poll[0] + delta[0]][ poll[1] + delta[1]][poll[2] +delta[2]]==0){

                    q.add(new int[]{poll[0] + delta[0], poll[1] + delta[1],  poll[2] +delta[2] });
                    matrix[poll[0] + delta[0]][poll[1] + delta[1]][poll[2] +delta[2]]
                            = matrix[poll[0]][poll[1]][poll[2]]+1;
                }

            }
        }

        if(nOfTarget != 0)
            return -1;
        return last-1;
    }



}