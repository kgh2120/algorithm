import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfMeeting = Integer.parseInt(br.readLine());

        Integer[][] meetings = new Integer[nOfMeeting][2];
        for (int i = 0; i < nOfMeeting; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, new EndTimeComparator());


        int result = 0;
        int currentTime = 0;
        for (int i = 0; i < nOfMeeting; i++) {
            if(currentTime <= meetings[i][0]){
                result++;
                currentTime = meetings[i][1];
            }
        }
        System.out.println(result);
    }

    class EndTimeComparator implements Comparator<Integer[]>{

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[1]-o2[1] == 0 ? o1[0]-o2[0] : o1[1]-o2[1];
        }
    }


    public static void main(String []args) throws Exception {
        new Main().solution();
    }
}





