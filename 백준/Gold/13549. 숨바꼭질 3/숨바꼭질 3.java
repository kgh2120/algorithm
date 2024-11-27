import java.io.*;
import java.util.*;

/**

 우선은 수빈이의 위치가, 동생보다 멀리 간 순간부터, 더이상 앞으로 갈 이유가 없음.
 이는 이전 문제들과 비슷함.

 이제 차이가 생긴건 아마 순간이동을 썼을 때, 시간이 지나지 않는다는 것임.
 하지만 순간이동을 계속 쓸 수 는 없고, 한번 쓰고 나면 변화한 위치에서 또 순간이동을 쓰는거임.
 이건 그대로 Queue를 쓰고, 현 위치에 대한 DP를 적용하면 될거라고 생각함.

 그러면 식을 다음과 같이 세울 수 있을듯.

 Subin s
 if(s.location > K){
 정답은 s.second + s.location-K
 } else {
 여기서 DP 기록보다 더 짧은 시간에 도달한 경우 큐에 넣기.
 q.add(new Subin(s.location+1, s.second + 1))   ;
 q.add(new Su)~~

 }

추가 TC

1 1
0

1 2
0

2 1
1

 **/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)  throws Exception {
        // 코드를 작성해주세요

        int[] dp = new int[100_001];

        st = new StringTokenizer(br.readLine());

        int subinInit = Integer.parseInt(st.nextToken());
        int targetLocation = Integer.parseInt(st.nextToken());

        Queue<Subin> subinQueue = new ArrayDeque<>();

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[subinInit] = 0;
        subinQueue.add(new Subin(subinInit, 0));

        while(!subinQueue.isEmpty()){

            Subin subin = subinQueue.poll();
            
            if(subin.location >= targetLocation){
                dp[targetLocation] = Math.min(dp[targetLocation], subin.second + subin.location - targetLocation);
            } else {
                move(subinQueue,dp, subin.location+1, subin.second+1);
                move(subinQueue,dp, subin.location-1, subin.second+1);
                move(subinQueue,dp, subin.location*2, subin.second);
            }

        }

        System.out.println(dp[targetLocation]);


    }

    static void move(Queue<Subin> queue, int[]dp, int nextLocation, int second){
        if(nextLocation < 0 || nextLocation > 100_000) return;

        if(dp[nextLocation] > second){
            dp[nextLocation] = second;
            queue.add(new Subin(nextLocation, second));
        }

    }

    static class Subin {
        int location;
        int second;

        public Subin(int location, int second){
            this.location = location;
            this.second = second;
        }

        @Override
        public String toString() {
            return "Subin{" +
                    "location=" + location +
                    ", second=" + second +
                    '}';
        }
    }
}
