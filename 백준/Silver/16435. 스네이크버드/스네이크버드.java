import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
    @author 김규현
    @since 2023-08-11
    @see
    @performance
    @category #
    @note

    과일먹으면 길이가 길어짐.
    낮은 과일일수록 먹으면 될 듯.

    과일 배열을 정렬해서 아래서부터 먹어 치우면 될 듯 하다.
    그러다가 사이즈가 안맞으면 out

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int idx = 0;
        while (idx < n && arr[idx] <= h) {
            h++;
            idx++;
        }
        System.out.println(h);




    }
}