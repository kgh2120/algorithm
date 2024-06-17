import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] countArray = new int[10];
    static int nOfKinds = 0;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] tanghuru = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        int fruitA = -1;
        int fruitB = -1;
        int fruitALastIndex = -1;
        int fruitBLastIndex = -1;

        int maxLength = -1;
        while (left <= right && right < n) {
            int next = tanghuru[right];
            if(fruitA == -1 ) {
                fruitA = next;
                fruitALastIndex = right;
            }else if(fruitA != next && fruitB == -1) {
                fruitB = next;
                fruitBLastIndex = right;
            }else { // 둘 다 찬 경우
                // 그런데 이미 같은 경우?
                if (fruitA == next) {
                    fruitALastIndex = right;
                }else if(fruitB == next) {
                    fruitBLastIndex = right;
                }else {
                    // 둘 중 index가 낮은 애가 나가라..
                    if(fruitALastIndex > fruitBLastIndex) {
                        left = fruitBLastIndex +1;
                        fruitB = next;
                        fruitBLastIndex = right;
                    }else {
                        left = fruitALastIndex +1;
                        fruitA = next;
                        fruitALastIndex = right;
                    }
                }
            }
            right++;
            maxLength = Math.max(maxLength, right - left);

        }

        System.out.println(maxLength);
    }




}