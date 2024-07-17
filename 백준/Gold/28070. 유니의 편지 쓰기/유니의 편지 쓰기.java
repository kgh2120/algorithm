import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringTokenizer subSt;

    static int[][] army;
    static int[][] matrix;
    static int maxYear;
    static int maxMonth;


    public static void main(String[] args) throws Exception {


        int nOfFriends = Integer.parseInt(br.readLine());
        army = new int[10001][13];
        int minYear = 10000;
        int minMonth = 13;

        for (int i = 0; i < nOfFriends; i++) {
            st = new StringTokenizer(br.readLine());
            subSt = new StringTokenizer(st.nextToken(), "-");

            int startYear = Integer.parseInt(subSt.nextToken());
            int startMonth = Integer.parseInt(subSt.nextToken());

            subSt = new StringTokenizer(st.nextToken(), "-");
            int endYear = Integer.parseInt(subSt.nextToken());
            int endMonth = Integer.parseInt(subSt.nextToken());

            army[startYear][startMonth]++;
            if (++endMonth == 13) {
                endYear++;
                endMonth = 1;
            }
            army[endYear][endMonth]--;
            if (minYear >= startYear) {
                if (minYear == startYear && minMonth < startMonth) {
                } else
                    minMonth = startMonth;
                minYear = startYear;
            }
        }

        // minYear, minMonth 부터 시작함.

        int maxValue = -1;
        int maxYear = 0;
        int maxMonth = 0;
        int cur = 0;

        while (minYear < 10000) {

            // minYear & minMonth인 거 cur에 추가하고 depth에 넣음.

            cur += army[minYear][minMonth];

            if (cur > maxValue) {
                maxValue = cur;
                maxYear = minYear;
                maxMonth = minMonth;

            }
            if (++minMonth == 13) {
                minMonth = 1;
                minYear++;
            }
        }
        // 마지막에 컨버팅 해주기
        String month = maxMonth < 10 ? "0"+maxMonth : String.valueOf(maxMonth);
        System.out.println(maxYear+"-"+ month);


    }


}