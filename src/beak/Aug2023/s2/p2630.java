package beak.Aug2023.s2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**

@author 규현
@since 2023-08-07
@url https://www.acmicpc.net/problem/2630
@level s2
@try 1
@performance 13112kb, 104ms
@category #재귀
@note 

 종이를 자른다. 종이를 자를 때 기준은 그 영역이 전부 같은 색이 아니면 자른다.
 여기서 색이란 1(파란색), 0(하얀색)이 있음.

 자르는 영역이 전부 같아야 한다는 뜻이다.
 종이를 자를 때에는 4등분을 해서 자른다.
 4등분은 가로, 세로를 기준으로 가운데로 자름.

 재귀를 통해서 가장 깊은 곳까지 들어가보고, 그 칸이 파란색인지, 하얀색인지를 체크한다.
 그리고 재귀를 나와서 4개의 영역이 전부 같은 색이라면, 해당 칸의 파란색의 수, 하얀색의 수를 -3해준다. (전부 같다면 4개로 카운팅 되지만, 자르지 않은 것으로 봐야 하기 때문에)



*/
public class p2630 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static String[][] matrix;
    static int nOfW, nOfB;
    static int n;

    static final int BLUE = 1;
    static final int WHITE = 0;
    static final int MIXED = -1;

    static int[][]deltas = {
            {0,0},{0,1},{1,0},{1,1}
    };


    public static void main(String[] args) throws Exception {



        n = Integer.parseInt(br.readLine());

        matrix = new String[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = st.nextToken();
            }
        }


        colorPaper(1,1,n);
        sb.append(nOfW)
                .append("\n")
                .append(nOfB);
        System.out.println(sb);


    }

    private static int colorPaper(int sr, int sc, int dist){
        // 마지막이었을 때
        if (dist == 1) {
            if (matrix[sr][sc].equals("1")) {
                nOfB++;
                return BLUE;
            }
            nOfW++;
            return WHITE;
        }

        //4개로 나눈다.
        int nOfRtB = 0;
        int nOfRtW = 0;

        int next = dist/2;
        for (int[] delta : deltas) {
            int nr = sr + delta[0] * next;
            int nc = sc + delta[1] * next;
            int rtVal = colorPaper(nr, nc, next);
            if(rtVal == BLUE)
                nOfRtB++;
            else if(rtVal == WHITE)
                nOfRtW++;

        }

        if (nOfRtB == 4) {
            nOfB -=3;
            return BLUE;
        } else if (nOfRtW == 4) {
            nOfW -=3;
            return WHITE;
        }
        return MIXED;

    }


}