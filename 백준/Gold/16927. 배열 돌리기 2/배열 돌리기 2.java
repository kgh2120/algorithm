import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
    @author 김규현
    @since 2023-08-08
    @see https://www.acmicpc.net/problem/16927
    @performance
    @category #반복문
    @note
    배열이 반시계방향으로 R번 회전을 한다.
    배열이 회전을 할 때, 배열의 둘레에 있는 애들을 기준으로 동일한 방향으로 회전을 함.
    그리고 그 안에는 지들끼리 회전을 한다.
    그렇다면 재귀를 통해 안과 밖을 따로 회전시켜줘야 한다고 생각함.
    R의 범위가 굉장히 크기 때문에, 그냥 돌릴수는 없다.
    배열을 회전시킬 때, 그 둘레횟수만큼 돌리면 처음과 같은 상태가 될 것이다.
    그럼 그 둘레를 D라고 할 때, R%D만큼만 돌리면 될 것이다.
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static StringTokenizer st;
    static String[][] matrix;
    static List<Integer> circumferences;
    static List<Position> positions;
    static int n,m,r;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        circumferences = new ArrayList<>();
        positions = new ArrayList<>();

        matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++)
                matrix[i][j] = st.nextToken();
        }

        getCircumference(0,0,n-1,m-1);
        // circumference 기준으로 rotate 돌리기
        
            for (int i = 0; i < circumferences.size(); i++) {
                int rotate = r % circumferences.get(i);
                Position c = positions.get(i);

                for (int j = 0; j < rotate; j++)
                    rotate(c.r1, c.c1, c.r2, c.c2);
            }
            for (String[] strings : matrix) {
                for (String string : strings) {
                    sb.append(string).append(" ");
                }
                sb.append("\n");

            }
            System.out.println(sb);


    }


    private static void rotate(int r1, int c1, int r2, int c2){
        String leftTop = matrix[r1][c1];
        String leftBot = matrix[r2][c1];
        String rightBot = matrix[r2][c2];
        String rightTop = matrix[r1][c2];

        // 왼쪽아래로 전진
        for (int i = r2; i >= r1+1; i--) {
            matrix[i][c1] = matrix[i-1][c1];
        }
        // 아래쪽 오른쪽으로 전진
        for(int i = c2; i >= c1+1; i--)
            matrix[r2][i] = matrix[r2][i-1];
        matrix[r2][c1+1] = leftBot;

        // 오른쪽 위로 전진
        for(int i = r1; i<r2-1; i++)
            matrix[i][c2] = matrix[i+1][c2];
        matrix[r2-1][c2] = rightBot;
        // 위쪽 왼쪽으로 전진
        for(int i = c1; i < c2-1; i++)
            matrix[r1][i] = matrix[r1][i+1];
        matrix[r1][c2-1] = rightTop;


    }

    private static void getCircumference(int r1, int c1, int r2, int c2){
        if(r1 >= r2 || c1 >= c2)
            return;
        int circumference = ((r2-r1) + c2-c1 ) * 2;
        circumferences.add(circumference);
        positions.add(new Position(r1,c1,r2,c2));
        getCircumference(r1+1,c1+1,r2-1,c2-1);
    }

    static class Position{
        int r1;
        int c1;
        int r2;
        int c2;

        public Position(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }

    }


}