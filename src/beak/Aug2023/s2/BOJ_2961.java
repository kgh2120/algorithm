package beak.Aug2023.s2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
    @author 김규현
    @since 2023-08-03
    @see https://www.acmicpc.net/problem/2961
    @performance 11472kb  76ms
    @category #부분 집합
    @note
    N개의 재료, 신맛(S), 쓴맛(B)
    신맛 : 재료들의 S 곱
    쓴맛 : 재료들의 B의 합.
    재료를 적절히 사용해서 (1개 이상 N개의 재료를 뽑아서) 신맛과 쓴맛의 차이를 작게 해야 한다.
    입력은 N
    신맛 쓴맛으로 준다.
    신맛과 쓴맛은  1_000_000_000 보다 작은 자연수이다.

    부분 집합을 구하고, 그 결과(total 신맛 - total 쓴맛)의 차이가 가장 최소인 값을 출력한다.
    시간 제한은 1초(1억). N은 1<= N <= 10 이기때문에 부분 2^10 (1024)에 들어갈 수 있다.
*/
public class BOJ_2961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static Food[] foods;
    static StringTokenizer st;
    static int min;
    public static void main(String[] args) throws IOException {
        setVariables();
        makeSubSet(0,1,0,0);
        System.out.println(min);
    }

    private static void makeSubSet(int cnt, int totalS, int totalB,int selectedCount){
        if (cnt == n ) {
            if(selectedCount > 0) // 1개 이상의 재료를 선택했을 때
                min  = Math.min(min, Math.abs(totalS - totalB)); // 신맛과 쓴맛의 차이가 min보다 작다면 min 변경
            return; // 재귀 종료
        }
        Food food = foods[cnt];
        // 해당 재료를 넣는다.
        makeSubSet(cnt+1, totalS * food.s, totalB + food.b, selectedCount+1);
        // 안넣는다.
        makeSubSet(cnt+1, totalS, totalB, selectedCount);
    }
    private static void setVariables() throws IOException {
        n = Integer.parseInt(br.readLine());
        foods = new Food[n];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i] = new Food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }

    static class Food{
        int s;
        int b;
        public Food(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }


}
