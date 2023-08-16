import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
    @author 김규현
    @since 2023-08-16
    @see
    @git
    @youtube
    @performance
    @category #
    @note

    각 나라부터 시작을 한다.
    승,무,패 기록을 가진 배열과 한 나라가 다른 나라와 경기를 했는지 체크하는 배열을 가지고 있는다.
    승,무,패의 횟수만큼 상대 나라의 승,무,패를 -1씩 해준다.
    이때 상대 나라의 승,무,패가 0이면 진입할 수 없고, 이미 경기를 했다면 마찬가지로 진입할 수 없다.

    이 과정대로 A나라의 승,무,패 순으로 다른 나라들에게 적용을 시키고, 마찬가지로 B,C,D.... 순으로 자신이 가진
    숫자만큼 과정을 진행시킨다.
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] wdl;
    static boolean [][] visited;
    static int result;
    public static void main(String[] args) throws Exception {
//        br = new BufferedReader(new StringReader("5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4\n" +
//                "4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3\n" +
//                "5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5\n" +
//                "5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4\n"+
//                "5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5"));

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            result = 0;
            wdl = new int[6][3];
            visited = new boolean[6][6];
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    wdl[j][k] = Integer.parseInt(st.nextToken());
                }
            }



            if(isValid())
                findAnswer(0,0);



            sb.append(result)
                    .append(" ");
        }
        System.out.println(sb);
    }

    private static boolean isValid(){

        for (int[] ints : wdl) {

            int sum = 0;
            for (int anInt : ints) {
                sum+= anInt;
            }
            if(sum != 5)
                return false;
        }
        return true;
    }

    private static void findAnswer(int countryNumber, int wdlNumber){
        if (countryNumber == 6) {
            if(isFinished())
                result = 1;
            return;
        }
        if (wdl[countryNumber][wdlNumber] == 0) {
            if (wdlNumber == 2) {
                findAnswer(countryNumber+1,0);
            }else{
                findAnswer(countryNumber,wdlNumber+1);
            }
        }else{
            // coutryNumber의 wdlNumber을 다 털고 진행한다
            for (int i = countryNumber + 1; i < 6; i++) {
                // 내꺼 -1
                // 상대꺼 -1
                if(wdl[i][2 - wdlNumber] == 0 || visited[countryNumber][i]) continue;
                wdl[countryNumber][wdlNumber]-=1;
                wdl[i][2 - wdlNumber]-=1;
                visited[countryNumber][i] = true;

                if (wdl[countryNumber][wdlNumber] == 0) {
                    if (wdlNumber == 2) {
                        findAnswer(countryNumber+1,0);
                    }else{
                        findAnswer(countryNumber,wdlNumber+1);
                    }
                }else
                    findAnswer(countryNumber,wdlNumber);


                visited[countryNumber][i] = false;
                wdl[countryNumber][wdlNumber]+=1;
                wdl[i][2 - wdlNumber]+=1;
            }
        }

    }

    private static boolean isFinished(){
        for (int[] ints : wdl) {
            for (int anInt : ints) {
                if(anInt != 0)
                    return false;
            }
        }
        return true;
    }

}