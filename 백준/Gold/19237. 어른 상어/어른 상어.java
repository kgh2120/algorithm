import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Shark[] sharks;
    static Map<Pos, Shark> movingShark;
    static List<Integer> livingShark;
    static int n, m, k;
    static Pos[] deltas = {

            new Pos(-1, 0),
            new Pos(1, 0),
            new Pos(0, -1),
            new Pos(0, 1)
    };

    static Smell[][] smells;

    public static void main(String[] args) throws Exception {
        setVariables();

        int time = 0;
        while (++time <= 1000) {
            // 냄새 시간 줄이기 및 냄새 살포
            consumeSmell();
            spreadSmell();

            // move shark
            moveShark();
            refreshShark();
            if(isFinished()) break;

        }
        if (time > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }

    }


    private static boolean isFinished(){
        return livingShark.size() == 1;
    }

    private static void refreshShark(){
        livingShark.clear();
        for (Shark shark : movingShark.values()) {
            livingShark.add(shark.index);
        }
        movingShark.clear();
    }

    private static void moveShark() {
        List<Pos> nonSmells = new ArrayList<>();
        List<Pos> selfSmells = new ArrayList<>();
        for (Integer index : livingShark) {
            nonSmells.clear();
            selfSmells.clear();
            Shark shark = sharks[index];
            // shark 주변 사방탐색 진행
            for (int i = 0; i < 4; i++) {
                Pos delta = deltas[i];
                int nr = shark.row + delta.row;
                int nc = shark.col + delta.col;

                if (isIn(nr, nc)) {
                    if (smells[nr][nc] == null) {
                        nonSmells.add(new Pos(nr, nc, i + 1));
                    } else if (smells[nr][nc].number == index) {
                        selfSmells.add(new Pos(nr, nc, i + 1));
                    }
                }
            }
            if (nonSmells.size() == 1) {
                // 1이면 그 방향으로 이동한다.
                holdShark(nonSmells.get(0), shark );
            } else if (nonSmells.size() > 1) {
                holdShark(shark.getNextLocation(nonSmells), shark);
            } else if (selfSmells.size() == 1) {
                holdShark(selfSmells.get(0), shark);
            } else if (selfSmells.size() > 1) {
                holdShark(shark.getNextLocation(selfSmells), shark);
            }
        }
    }

    private static void holdShark(Pos pos, Shark shark) {
        if (!(movingShark.containsKey(pos) && movingShark.get(pos).index < shark.index)) {
            movingShark.put(pos, shark);
            shark.row = pos.row;
            shark.col = pos.col;
            shark.direction = pos.direction;
        }
    }

    private static void spreadSmell() {
        for (Integer index : livingShark) {
            Shark shark = sharks[index];
            smells[shark.row][shark.col] = new Smell(index, k);
        }

    }

    private static void consumeSmell() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Smell smell = smells[i][j];
                if (smell != null && --smell.time == 0) {
                    smells[i][j] = null;
                }

            }
        }
    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sharks = new Shark[m + 1];
        smells = new Smell[n][n];
        livingShark = new ArrayList<>();
        movingShark = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int index = Integer.parseInt(st.nextToken());
                if (index == 0) {
                    continue;
                }
                sharks[index] = new Shark(index, i, j);
                livingShark.add(index);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sharks[i + 1].direction = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < 4; l++) {
                    sharks[i + 1].priority[j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }


    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    static class Pos {

        int row;
        int col;
        int direction;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Pos(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return row == pos.row && col == pos.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static class Smell {

        int number;
        int time;

        public Smell(int number, int time) {
            this.number = number;
            this.time = time;
        }
    }

    static class Shark {

        int index;
        int row;
        int col;
        int direction;
        int[][] priority;

        public Shark(int index, int row, int col) {
            this.index = index;
            this.row = row;
            this.col = col;
            priority = new int[5][4];
        }


        public Pos getNextLocation(List<Pos> pos) {
            for (int p : priority[direction]) {
                for (Pos po : pos) {
                    if(p == po.direction)
                        return po;
                }
            }
            return null;
        }
    }

}