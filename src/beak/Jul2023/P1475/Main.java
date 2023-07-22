package beak.Jul2023.P1475;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @url : https://www.acmicpc.net/problem/1475
 * @info : BOJ S5
 * @time : 10min
 * @try : 2
 * @type : array
 * @perfomance : memory : 11516KB, time : 80ms
 */
public class Main {

    /*
        0-9까지의 플라스틱 세트가 있다.
        주어진 숫자를 이 세트를 활용해서 만드려고 한다.
        주어진 숫자에서 사용된 각 수를 카운팅 하고 가장 많이 카운팅 된 애가 정답이다.
        왜냐하면 한 세트당 숫자가 1개만 있기 때문임.
        하지만 여기서 6과 9는 뒤집어서 사용할 수 있다고 함.
        그래서 6과 9의 개수를 합치고 /2를 해서 얘들은 카운팅 해줘야 함.
        기본적으로 배열을 만들어서 숫자를 카운팅 한다.
        하지만 6과 9는 같은 칸에 배치한다. (6에 배치)
        비교를 할 때 6의 경우엔 /2를 하고 비교해준다.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String number = br.readLine();
        int[] arr = new int[10];
        for (char c : number.toCharArray()) {
            if(c == '9')
                arr[6]++;
            else
                arr[c - '0']++;
        }
        int max = -1;
        for(int i = 0; i<10; i++){
            int target = arr[i];
            if(i == 6){
                target ++;
                target /=2;
            }
            max = Math.max(max, target);
        }
        System.out.println(max);

    }



}