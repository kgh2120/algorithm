import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[][][] visited;


    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        int n = Integer.parseInt(input.readLine());

        st = new StringTokenizer(input.readLine());

        int [] arr = new int[3];
        Arrays.fill(arr,1);
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + 1;
        }

        visited = new boolean[arr[0]][arr[1]][arr[2]];

        // 이제 때리기

        Queue<int[]> mutal = new ArrayDeque<>();

        mutal.add(new int[]{arr[0]-1, arr[1]-1, arr[2] -1});

        int turn = 0;
        while(!mutal.isEmpty()){
            int size = mutal.size();
            turn++;
            while(size-- > 0){

                int[] scv = mutal.poll();

                // 어디를 때릴지 고르기
                for(int i = 0; i<3; i++){
                    for(int j = 0;j<3; j++){
                        if(i == j) continue;
                        for(int k =0; k<3; k++){
                            if(j == k || i == k) continue;
                            // i -> 9 j -> 3; k -> 1
                            // 1, 2, 3 
                            int a = calcHp(scv[0], convertIndex(i) );
                            int b = calcHp(scv[1], convertIndex(j));
                            int c = calcHp(scv[2], convertIndex(k));

                            if(visited[a][b][c]) continue;

                            visited[a][b][c] = true;
                            mutal.add(new int[]{a,b,c});

                            if (a == 0 && b == 0 && c == 0) {
                                System.out.println(turn);
                                return;
                            }


                        }
                    }
                }

            }
        }
    }

    static int convertIndex(int i) {
        switch (i) {
            case 0: return 9;
            case 1: return 3;
            case 2: return 1;
        }
        return -1;
    }

    static int calcHp(int hp, int damage){
        return Math.max(0, hp-damage);
    }
}
