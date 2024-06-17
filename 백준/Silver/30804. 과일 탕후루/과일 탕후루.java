import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tanghuru = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        Counter counter = new Counter();
        int maxLength = -1;
        while (left <= right && right < n) {
            int next = tanghuru[right];
            if (counter.canPush(next)) {
                counter.push(tanghuru[right++]);
            } else {
                while (!counter.canPush(next)) {
                    counter.pop(tanghuru[left++]);
                }
            }
            maxLength = Math.max(maxLength, right - left);
        }

        System.out.println(maxLength);
    }


    static class Counter {
        int[] arr;
        int nOfKinds;

        public Counter() {
            arr = new int[10];
            nOfKinds = 0;
        }

        public void push(int n) {
            if (arr[n]++ == 0)
                nOfKinds++;
        }

        public boolean canPush(int n) {
            if (arr[n] != 0) return true;
            else return nOfKinds < 2;
        }

        public void pop(int n) {
            if (--arr[n] == 0) {
                nOfKinds--;
            }
        }
    }

}