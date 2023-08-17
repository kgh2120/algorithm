import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;



/**

@author 규현
@since 2023-08-17
@url
@level
@try
@performance
@category #
@note

 탱크 게임을 구현하는 문제

 게임 필드를 구성하는 내용으로는
땅, 벽(벽돌, 강철), 물, 전차(상,하,좌,우 방향)이다.
각 명령어는 전차의 방향 바꾸기 후 이동(가능한 경우)와 포탄 발사이다

포탄 발사의 경우 바라보고 있는 방향으로 쭉 나아간다.
이때 벽돌 벽은 포탄과 박으면 사라지고, 강철은 아무 일도 없음.

 총 화면의 크기는 20 * 20이고 명령의 개수는 100개이다.

 시간 제한은 98개 TC가 4초 이내, 간단하게 하면 한 TC가 0.04초 안에 종료되어야 한다는 것.
 명령 중 가장 긴 명령이라고 하면 100개의 명령이 전부 포탄을 발사하고, 끝에서 끝까지 포탄이 날아가는 경우로
 100 * 20이 제일 긴 경우일 것이다. 그러면 10^3 * 2, 10^6이 1ms로 0.01초 이기 때문에 시간 제한 자체는
 문제가 없어 보인다.

 문제를 풀기 위해 필요해보이는 변수로는 현재 전차의 위치와 현재 바라보고 있는 방향, 방향(상,하,좌,우)에 따른
 이동 값이 필요해보인다.


*/
public class Solution {

    // 입출력을 위한 3종 세트
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 게임 맵
    static char[][] map;
    // 명령
    static String commands;
    // 전체 map의 크기
    static int n,m;
    // 현재 전차의 위치
    static int r,c;
    // 현재 전차의 방향
    static char direction;
    //방향에 따른 이동
    static int[][] deltas;



    static final char RIGHT = '>';
    static final char LEFT = '<';
    static final char UP = '^';
    static final char DOWN = 'v';


    public static void main(String[] args) throws Exception {

//        br = new BufferedReader(new StringReader(INPUT));

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {

            setVariables();

            action();

            appendResult(test);
        }
        System.out.println(sb);
//        System.out.println(sb.toString().equals(OUTPUT));
    }

    private static void action() {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);

            switch (command) {
                case 'S': shoot();
                    break;
                case 'U': move('U');
                    break;
                case 'D': move('D');
                    break;
                case 'L': move('L');
                    break;
                case 'R': move('R');
                    break;
            }
        }
    }


    private static void shoot(){
        // 지금 위치에서 방향으로 쭉 나아가기.
        // 만약 벽에 박았다면 멈추기
        // 근데 벽이 벽돌 벽이라면 '.'으로 바꿔주기

        int[] delta = deltas[direction];
        int nr = r + delta[0];
        int nc = c + delta[1];
        while (isIn(nr, nc)) {

            if ('*' == map[nr][nc]) {
                map[nr][nc] = '.';
                break;
            } else if ('#' == map[nr][nc]) {
                break;
            }
            nr += delta[0];
            nc += delta[1];
        }

    }

    private static void move(char nextDirection){

        direction = nextDirection;
        int[] delta = deltas[direction];
        int nr = r + delta[0];
        int nc = c + delta[1];
        map[r][c] = (char)deltas[direction][2];
        if (isIn(nr,nc) && map[nr][nc] == '.') {
            map[r][c] = '.';
            r = nr;
            c = nc;
            map[r][c] = (char)deltas[direction][2];
        }
    }

    private static boolean isIn(int row, int col) {
        return row >= 0 && row <n && col >= 0 && col < m;
    }




    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        deltas = new int[128][3];

        deltas['U'][0] = -1;
        deltas['U'][1] = 0;
        deltas['U'][2] = UP;
        deltas['D'][0] = 1;
        deltas['D'][1] = 0;
        deltas['D'][2] = DOWN;
        deltas['R'][0] = 0;
        deltas['R'][1] = 1;
        deltas['R'][2] = RIGHT;
        deltas['L'][0] = 0;
        deltas['L'][1] = -1;
        deltas['L'][2] = LEFT;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char component = line.charAt(j);
                map[i][j] = component;
                if ("<>^v".contains(String.valueOf(component))) {
                    r = i;
                    c = j;
                    if(component == RIGHT)
                        direction = 'R';
                    if(component == LEFT)
                        direction = 'L';
                    if(component == UP)
                        direction = 'U';
                    if(component == DOWN)
                        direction = 'D';
                }
            }
        }

        br.readLine();
        commands = br.readLine();
    }


    private static void appendResult(int test) {
        sb.append("#")
                .append(test)
                .append(" ");
        for (char[] row : map) {
            for (char block : row) {
                sb.append(block);
            }
            sb.append("\n");
        }
    }


  
}