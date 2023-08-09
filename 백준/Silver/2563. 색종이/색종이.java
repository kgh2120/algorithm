import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
    @author 김규현
    @since 2023-08-09
    @see https://www.acmicpc.net/problem/2563
    @performance
    @category # 구현
    @note

    가로,세로가 100인 흰색 도화지가 있다고 한다. 여기에서 색종이를 붙혀서 검게 만드려고 한다.
    검게될 영역을 체크해주고, 이 개수를 세면 될 듯 하다.

    시간 제한은 1초고, N이 100, 색종이 수도 100이기 때문에 문제 없어보인다.
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static boolean[][] paper;



    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        paper = new boolean[100][100];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int a = 0; a < 10; a++) {
                for(int b= 0; b<10; b++)
                    paper[x+a][y+b] = true;
            }
        }

        int cnt = 0;
        for (boolean[] p : paper) {
            for (boolean b : p) {
                if(b)
                    cnt++;
            }
        }
        System.out.println(cnt);




    }



}