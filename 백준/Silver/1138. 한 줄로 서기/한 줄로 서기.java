import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


/*
    1138 한 줄로 섯기

    학생들이 키 순서대로 서있음.

    키가 작은 학생부터 위치를 배정한다.

    배열을 만들고 키 순서에 맞는 위치에 배정한다. 작은놈부터.

    특정 위치에 작은 애가 배정받게 된다면, 그 위치보다 뒤에 있는 애들은 수를 1씩 줄여준다.
    그 다음에 애들을 배치한다. 위의 과정에서 약간의 낭비가 발생하지만, 어차피 n이 10이니까 노상관일듯 하다.
 */
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int VISITED = -1;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];

        int[] location = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            location[i] = i;
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k<n; k++) {
            int people = arr[k];
            int i;
            for (i = 0; i < n; i++) {
                if(location[i] == VISITED)
                    continue;;
                if (location[i] == people) {
                    answer[i] = k + 1;
                    location[i] = VISITED;
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if(location[j] == VISITED)
                    continue;

                location[j] = Math.max(0, location[j] - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);



    }

}