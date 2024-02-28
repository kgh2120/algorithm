import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char[] commands = br.readLine().toCharArray();
            int nOfNumber = Integer.parseInt(br.readLine());
            int[] numbers = new int[nOfNumber];
            st = new StringTokenizer(br.readLine().replace('[',' ').replace(']', ' ').trim(),",");
            for (int j = 0; j < nOfNumber; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            int l = 0;
            int r = nOfNumber-1;

            boolean isReversed = false;
            boolean result = true;
            for (char command : commands) {
                if (command == 'R') {
                    isReversed = !isReversed;
                    continue;
                }

                if(isReversed)
                    r--;
                else
                    l++;


                if ( l > nOfNumber || r < -1) {
                    result = false;
                    break;
                }
            }

            if (result) {
                sb.append('[');
                if (!isReversed) {
                    for (int j = l; j <=r ; j++) {
                        sb.append(numbers[j]);
                        if(j != r)
                            sb.append(",");
                    }
                }else{
                    for (int j = r; j >=l ; j--) {
                        sb.append(numbers[j]);
                        if(j != l)
                            sb.append(",");
                    }
                }

                sb.append("]\n");
            }else{
                sb.append("error\n");
            }
        }
        System.out.println(sb);


    }


}