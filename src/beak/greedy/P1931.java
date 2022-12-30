package beak.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘의 예시로 자주 나오는 회의실 배정 문제.
 * 핵심은 이전 선택이 다음 선택에 영향을 주지 않는다는 것 이었다.
 * 이 문제에서 이전 선택이 다음 선택에 영향을 주지 않는 기준은
 * 회의 A의 종료 시간이 회의 B의 시작 시간보다 앞이여야 한다는 점이다.
 * 이 조건 하에, 빠르게 종료되는 회의들을 선택하면, 가장 많은 회의를 배정할 수 있는 것이다.
 * 그래서 빠르게 종료되는 회의를 기준으로 정렬을 진행하였다.
 * 하지만 이 과정에서 회의 시작에 대한 정렬을 해주지 않아서 한번 틀렸다.
 * 생각을 하긴 했는데, 알아서 해주는 줄 알았다.
 * 항상 반례를 잘 고민해야겠다.
 */
public class P1931 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfMeeting = Integer.parseInt(br.readLine());

        Integer[][] meetings = new Integer[nOfMeeting][2];
        for (int i = 0; i < nOfMeeting; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new EndTimeComparator());


        int result = 0;
        int currentTime = 0;
        for (int i = 0; i < nOfMeeting; i++) {
            if(currentTime <= meetings[i][0]){
                result++;
                currentTime = meetings[i][1];
            }
        }
        System.out.println(result);
    }

    class EndTimeComparator implements Comparator<Integer[]>{

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[1]-o2[1] == 0 ? o1[0]-o2[0] : o1[1]-o2[1];
        }
    }


    public static void main(String []args) throws Exception {
        new P1931().solution();
    }
}





