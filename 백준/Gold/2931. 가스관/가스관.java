import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Pipe> pipes; // ������ ����
    static char[][] map; // ��ü ����
    static int r, c; // ���� ��ġ
    static char direction; // ���� ����
    static int destinationR, destinationC; // ������ Z�� ��ǥ
    static int n, m; // ��ü ������ ����,���� ����
    static int[][] deltas = { // ���Ž��
            {-1, 0, 'U'}, {1, 0, 'D'}, {0, 1, 'R'}, {0, -1, 'L'}
    };
    static boolean[][] visited;
    static boolean[][] hasComponent;

    public static void main(String[] args) throws Exception {

        setPipes(); // �̿��� ������ ����


        setVariables(); // ���� ����
        findFirstPipe(); // ù��° ������(�� ��ó�� �ִ� ������) ã��
        findTargetBlock(); // ���� ���� ã��
        findCorrectPipe(); // 7���� �������� �־�鼭 ��� ����

        System.out.println(sb);

    }

    private static void setPipes() {
        pipes = new HashMap<>(); // �� ĳ���� �� �̵� ������
        pipes.put('|', new PipeL());
        pipes.put('-', new PipeM());
        pipes.put('+', new PipeCross());
        pipes.put('1', new Pipe1());
        pipes.put('2', new Pipe2());
        pipes.put('3', new Pipe3());
        pipes.put('4', new Pipe4());
    }

    private static boolean[][] copy() {
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++)
            System.arraycopy(visited[i], 0, v[i], 0, m);
        return v;
    }

    private static void findCorrectPipe() {
        for (Map.Entry<Character, Pipe> e : pipes.entrySet()) {
            map[r][c] = e.getKey();
            boolean[][] v = copy();
            int checked = 0;
            int tempR = r;
            int tempC = c;
            char tempD = direction;
            boolean flag = false;
            while (true) {
                Pipe pipe = pipes.get(map[tempR][tempC]);

                if (e.getKey() == '+' && tempR == r && tempC == c) checked++;
                if (pipe == null) break; // .�� ������ ��� (���� ���� ���)
                Cor cor = pipe.move(tempR, tempC, tempD);
                if (cor == null) break; // �߸��� ������ ������ ���
                if (!isIn(cor.row, cor.col)) break; // map�� ������ �Ѿ�� ���
                tempR = cor.row;
                tempC = cor.col;
                tempD = cor.direction;
                v[tempR][tempC] = true;
                if (tempR == destinationR && tempC == destinationC) { // ������ Z�� ã�� ���
                    flag = true;
                    break;
                }
            }

            if (flag) {// �ش� �������� �������� ã�Ҵٸ�
                if (e.getKey() == '+') { // + ��� 2���� ���İ����� üũ���ش�.
                    if (checked != 2)
                        continue;
                }
                if (!visitAll(v)) continue;

                // ó�� ����� �� �ִ� ���� �����̱� ������ ������ �����Ѵ�.
                sb
                .append(r + 1)
                .append(" ")
                .append(c + 1)
                .append(" ")
                .append(e.getKey());

                break;
            }
        }
    }

    private static boolean visitAll(boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (hasComponent[i][j] != visited[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void findTargetBlock() {
        while (true) { // ���� ��ġ�� ã�´�.
            Pipe pipe = pipes.get(map[r][c]);
            visited[r][c] = true;

            if (pipe == null) break; // .�� ������ ��� (���� ���� ���)
            Cor cor = pipe.move(r, c, direction);
            r = cor.row;
            c = cor.col;
            direction = cor.direction;
        }
        hasComponent[r][c] = true;
    }

    private static void findFirstPipe() {
        for (int[] del : deltas) {
            int nr = r + del[0];
            int nc = c + del[1];
            if (isIn(nr, nc)) {
                if (map[nr][nc] != '.' && map[nr][nc] != 'Z') {
                    direction = (char) del[2];
                    r = nr;
                    c = nc;
                    break;
                }
            }
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    private static void setVariables() throws IOException { // ���� ����
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m]; // ����
        visited = new boolean[n][m];
        hasComponent = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char component = line.charAt(j);
                map[i][j] = component;
                if (component == 'M') { // ���� ��ġ�� ã�´�.
                    r = i;
                    c = j;
                    visited[r][c] = true;
                } else if (component == 'Z') { // ��ġ���� ��ġ�� ã�´�.
                    destinationR = i;
                    destinationC = j;
                }

                if (component != '.') {
                    hasComponent[i][j] = true;
                }
            }

        }
    }


    // Pipe �������̽�
     interface Pipe {
        Cor move(int row, int col, char direction);
    }

    // Pipe�� ź ��� ��ǥ�� ������ ���� Ŭ����
    static class Cor {
        int row;
        int col;
        char direction;

        public Cor(int row, int col, char direction) {
            super();
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

    // | ������
    static class PipeL implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'U') {
                return new Cor(row - 1, col, direction);
            } else if (direction == 'D')
                return new Cor(row + 1, col, direction);
            return null;
        }
    }

    // - ������
    static class PipeM implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'R') {
                return new Cor(row, col + 1, direction);
            } else if (direction == 'L')
                return new Cor(row, col - 1, direction);
            return null;
        }
    }

    // + ������
    static class PipeCross implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'U') {
                return new Cor(row - 1, col, direction);
            } else if (direction == 'D')
                return new Cor(row + 1, col, direction);
            else if (direction == 'R')
                return new Cor(row, col + 1, direction);
            return new Cor(row, col - 1, direction);
        }
    }

    // 1(��) ������
    static class Pipe1 implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'U') {
                return new Cor(row, col + 1, 'R');
            } else if (direction == 'L')
                return new Cor(row + 1, col, 'D');
            return null;
        }
    }

    // 2(��) ������
    static class Pipe2 implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'D') {
                return new Cor(row, col + 1, 'R');
            } else if (direction == 'L')
                return new Cor(row - 1, col, 'U');
            return null;
        }
    }

    // 3 (��) ������
    static class Pipe3 implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'D') {
                return new Cor(row, col - 1, 'L');
            } else if (direction == 'R')
                return new Cor(row - 1, col, 'U');
            return null;
        }
    }

    // 4(��) ������
    static class Pipe4 implements Pipe {
        @Override
        public Cor move(int row, int col, char direction) {
            if (direction == 'R') {
                return new Cor(row + 1, col, 'D');
            } else if (direction == 'U')
                return new Cor(row, col - 1, 'L');
            return null;
        }
    }
}