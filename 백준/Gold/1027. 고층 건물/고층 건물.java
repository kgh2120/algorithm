import java.util.*;
import java.io.*;

public class Main {


    static int [] buildings;
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        setVariables();
        int length = buildings.length;;
        int max = -1;
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if(i == j) continue;
                if (1 == Math.abs(i - j)) {
                    count++;
                    continue;
                }
                int x1,y1,x2,y2 = 0;
                if(buildings[i] > buildings[j]) {
                    x1 = i;
                    y1 = buildings[i];
                    x2 = j;
                    y2 = buildings[j];
                } else {
                    x2 = i;
                    y2 = buildings[i];
                    x1 = j;
                    y1 = buildings[j];
                }

                int k = x1 < x2 ? 1 : -1;
                int kk = k;
                boolean result = true;
                while (x1 + kk != x2) {

                    int target = buildings[x1+kk];
                    int index = Math.abs(kk);

                    int cutline = calculateHeight(x1, y1, x2, y2, index);
                    if (target >= cutline) {
                        result = false;
                        break;
                    }
                    kk += k;
                }

                if(result)
                    count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);

    }

    private static int calculateHeight(int x1, int y1, int x2, int y2, int index){
        double height = y1 - (y1-y2) * 1.0 / Math.abs(x2-x1) * index;
        return (int) Math.ceil(height);
    }

    static void setVariables() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        buildings = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++)
            buildings[i] = Integer.parseInt(st.nextToken());
    }
}
