import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < w; i++) {
            // 각 칸의 높이당 옆으로 가면서 그 개수를 센다.
            // 옆으로 가다가 나보다 같거나 큰 애가 등장하면 정지한다.
            for (int height = 1; height <= arr[i]; height++) {
                int value = 0;
                for (int j = i + 1; j < w; j++) {
                    if (height <= arr[j]) {
                        answer += value;
                        break;
                    }
                    value++;

                }
            }
        }
        System.out.println(answer);

    }



}