import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maximumWeight = Integer.parseInt(br.readLine());
        int numberOfCars = Integer.parseInt(br.readLine());


        int currentWeight = 0;
        Queue<Integer> weightQueue = new ArrayDeque<>();
        int i;
        for (i = 1; i <= numberOfCars; i++) {
            int car = Integer.parseInt(br.readLine());

            // 차가 들어옴. 큐가 4개 이하면 추가. 4개 이상이면 가장 밖에꺼 빼고 현재 무게 + 차 무게 > maxweight 다시 시도.

            if (weightQueue.size() >= 4) {
                currentWeight -= weightQueue.poll();
            }
            weightQueue.offer(car);
            currentWeight += car;
            if (currentWeight > maximumWeight) {
                break;
            }
        }
        System.out.println(--i);




    }


}