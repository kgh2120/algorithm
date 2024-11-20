import java.util.*;
import java.io.*;


/*
    추가 테케

    깔끔하게 다 박히는 경우

    4
    4
    4
    4
    4
    4

    4
    
    하나밖에 못 박는 경우
    
    4
    4
    1
    1
    1
    1
    
    1

    
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static int[] parents;
    static int answer;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        for(int i = 0; i<= n; i++)
            parents[i] = i;

        for(int i = 0; i<p; i++){
            int num = Integer.parseInt(br.readLine());

            int parent = find(num);

            if(parent == 0)
                break;

            parents[parent] = parent -1;
            answer++;
        }
        System.out.println(answer);
    }

    static int find(int i){
        if(parents[i] == i)
            return i;
        return parents[i] = find(parents[i]);
    }
}
