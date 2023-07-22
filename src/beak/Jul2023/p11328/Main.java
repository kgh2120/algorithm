package beak.Jul2023.p11328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @url : https://www.acmicpc.net/problem/11328
 * @info : BOJ B2
 * @time : ?
 * @try : 2
 * @type : 배열, 정렬
 * @performance : memory : 25232, time : 340ms
 */
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final String S = "Possible";
    static final String F = "Impossible";


    // 아니면 뭐.. 미리 만들어도 되고?? 배열로?

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        loop: for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char[] left = st.nextToken().toCharArray();
            char[] right = st.nextToken().toCharArray();

            if(left.length != right.length){
                sb.append(F).append("\n");
            }else{
                Arrays.sort(left);
                Arrays.sort(right);
                for(int j = 0; j< left.length;j++)
                    if(left[j]!=right[j]){
                        sb.append(F).append("\n");
                        continue loop;
                    }
                sb.append(S).append("\n");
            }
        }

        System.out.println(sb);



    }





}