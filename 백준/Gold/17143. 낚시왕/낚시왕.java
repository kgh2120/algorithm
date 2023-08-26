import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[][] matrix;
    static int n, m, k;

    static int[][] deltas = {
            {},
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    static HashMap<Integer, Shark> sharks;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        matrix = new int[n + 1][m + 1];

        sharks = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (matrix[r][c] == 0) {
                matrix[r][c] = z;
                sharks.put(z, new Shark(r, c,
                        speed,
                        deltas[d][0],
                        deltas[d][1],
                        z));
            }
            else{
                if (matrix[r][c] < z) {
                    sharks.remove(matrix[r][c]);
                    matrix[r][c] = z;
                    sharks.put(z, new Shark(r, c,
                            speed,
                            deltas[d][0],
                            deltas[d][1],
                            z));
                }
            }

        }

        int fisher = 0;
        int result = 0;
        while (++fisher <= m) {

            int w = killShark(fisher);
            result += w;
            moveShark();

        }

        System.out.println(result);


    }

    private static void moveShark() {
        // 각 shark들 이동시키기
        int[][] nMatrix = new int[n + 1][m + 1];
        for (Map.Entry<Integer, Shark> e : sharks.entrySet()) {

            Shark shark = e.getValue();
            // isIn이 깨지면 방향 바꾸기.
            int nr = shark.r;
            int nc = shark.c;
            for (int i = 0; i < shark.s; i++) {
                if (!isIn(nr + shark.nextR, nc + shark.nextC)) {
                    shark.nextR *= -1;
                    shark.nextC *= -1;
                }
                nr += shark.nextR;
                nc += shark.nextC;
            }

            shark.r = nr;
            shark.c = nc;
            int before = nMatrix[nr][nc];
            if(before < e.getKey()) nMatrix[nr][nc] = e.getKey();
        }

        matrix = nMatrix;
        HashMap<Integer, Shark> nMap = new HashMap<>();
        for (int[] ints : nMatrix) {
            for (int anInt : ints) {
                if(anInt == 0) continue;
                nMap.put(anInt, sharks.get(anInt));
            }
        }

        sharks = nMap;

    }

    private static boolean isIn(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= m;
    }

    private static int killShark(int c) {
        for (int i = 1; i <= n; i++) {
            int size = matrix[i][c];
            if (size != 0) {
//                Shark shark = sharks.get(matrix[i][c]);
                sharks.remove(size);
                matrix[i][c] = 0;
                return size;
            }
        }
        return 0;
    }

    static class Shark {

        int r;
        int c;
        int s;
        int nextR;
        int nextC;
        int z;

        public Shark(int r, int c, int s, int nextR, int nextC, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.nextR = nextR;
            this.nextC = nextC;
            this.z = z;
        }

    }


}