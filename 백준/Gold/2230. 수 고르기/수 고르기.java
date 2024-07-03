import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
            set.add(number);
        }

        boolean isDup = false;
        if (arr.length != set.size()) {
            isDup = true;
        }

        if (isDup && m == 0) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = arr[i];

            int target = left - m;


            int targetIndex = Arrays.binarySearch(arr, target);
            if (targetIndex < 0) {
                targetIndex = -(targetIndex + 2);
            }

            if(targetIndex >= n || targetIndex < 0)
                continue;

            int right = arr[targetIndex];
            if (left == right) {
                if (targetIndex == 0) {
                    right = arr[targetIndex+1];
                } else if (targetIndex == n - 1) {
                    right = arr[targetIndex-1];
                }else
                    right = Math.min(arr[targetIndex+1], arr[targetIndex-1]);
            }

            int diff = Math.abs(right - left);
            if(diff >= m)
                min = Math.min(diff, min);
        }
        System.out.println(min);


    }


}