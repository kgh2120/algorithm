import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
    @author 김규현
    @since 2023-08-11
    @see
    @git
    @youtube
    @performance
    @category #
    @note

    조합을 통해 M개의 치킨을 고른다.
    집들이 치킨집과의 거리를 계산해서 최소값을 저장하고, 모든 연산이 끝나면 전체 최소값을 업데이트 한다.

    전체 크기 N <= 50; 고를 수 있는 최대 치킨집 M개

    치킨집이 X개라면
    XCM * (N^2 - X) * X회 반복.
    오른쪽 연산은 많아봐야 50^3 ??  M <= X <= 13 제일 큰 상황인 13C6이어도 1716이니
    가능할 듯 ?? 모르겠네
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;

    static List<좌표> 집;
    static List<좌표> 치킨집;
    static int 진짜최소거리;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        진짜최소거리 = Integer.MAX_VALUE;
        집 = new ArrayList<>();
        치킨집 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    집.add(새로운_좌표(i,j));
                }
                if (num == 2) {
                    치킨집.add(새로운_좌표(i,j));
                }
            }
        }

        조합(0,0,new int[m]);
        System.out.println(진짜최소거리);

    }

    private static void 조합(int 순번, int 시작순번,int[]선택된_순번){
        if (순번 == m) {
            도시치킨거리계산(선택된_순번);
            return;
        }
        for (int i = 시작순번; i < 치킨집.size(); i++) {
            선택된_순번[순번]=i;
            조합(순번 + 1, i + 1, 선택된_순번);
        }
    }

    private static void 도시치킨거리계산(int[]선택된_순번){
        int 도시의치킨거리 = 0;
        for (좌표 좌표 : 집) {
            int 최소거리 = Integer.MAX_VALUE;
            for (int 치킨집순번 : 선택된_순번) {
                좌표 치킨 = 치킨집.get(치킨집순번);
                최소거리 = Math.min(최소거리, Math.abs(좌표.행 - 치킨.행) + Math.abs(좌표.열 - 치킨.열));
            }
            도시의치킨거리 += 최소거리;
        }
        진짜최소거리 = Math.min(진짜최소거리, 도시의치킨거리);
    }
    private static 좌표 새로운_좌표(int 행,int 열){
        return new 좌표(행,열);
    }
    static class 좌표{
        int 행;
        int 열;

        public 좌표(int 행, int 열) {
            this.행 = 행;
            this.열 = 열;
        }
    }

}