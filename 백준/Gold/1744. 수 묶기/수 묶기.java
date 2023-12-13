import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));





    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;

        // 음수가 나올때 까지 반복
        int left = 0;
        while (left+1 < n) {
            // 지금 위치가 양수야
            if(arr[left] > 0)
                break;

            // 내 다음이 양수야, 그래서 짝을 못지어
            if (arr[left + 1] > 0) {
                sum += arr[left++];
                break;
            }
            // 나랑 나 다음이 둘 다 음수쪽이야. 그래서 곱해.
            sum += arr[left] * arr[left+1];
            left += 2;
        }

        // 여기서 나오면 left는 이제 양수야.
        int right = n-1;
        while (right >= left) {
            if (right == left) {
                sum += arr[left];
                break;
            }

            if (right == left + 1) {
                sum += calcPositiveNumber(arr[left], arr[left+1]);
                break;
            }

            sum += calcPositiveNumber(arr[right], arr[right-1]);
            right-=2;
        }


        System.out.println(sum);
    }

    private static int calcPositiveNumber(int l, int r){
        if(l == 1 || r == 1)
            return l+r;
        return l*r;
    }





}