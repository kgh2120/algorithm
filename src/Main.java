import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        int [] lis = new int[n];
        Arrays.fill(lis,Integer.MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = arr[0];
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(lis, arr[i]);
            if(idx >= 0)
                continue;
            int candidateIndex = - (idx+1);
            if(lis[candidateIndex] > arr[i])
                lis[candidateIndex] = arr[i];
        }
        int count = 0;
        for (int number : lis) {
            if(number == Integer.MAX_VALUE)
                break;
            count++;
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}