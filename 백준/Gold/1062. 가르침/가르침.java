import java.util.*;
import java.io.*;
public class Main {

    static int n;
    static int k;
    static int[] selected;
    static String[] words;
    static int answer;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        setVariable();

        if(k < 5){
            System.out.println(0);
            return;
        }

        // 조합 굴리기
        combination(0, 5);
        System.out.println(answer);

    }

    private static void combination(int i, int depth){
        // 재귀 종료 조건, nCk 선택한 경우
        if(depth == k){
            int cnt = 0;
            for(String w : words){
                int end = w.length()-4;
                boolean check = true;
                for(int idx = 4; idx < end; idx++){
                    int k =w.charAt(idx)-'a';
                    if(selected[k] != 1){
                        check = false;
                        break;
                    }
                }

                if(check){
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
            return;
        }


        // i가 오른쪽으로 와서 너무 와서 k개를 선택 못할 경우
        // if(i + (k-depth)>= 26)
        //    return;

        for(int number = i; number < 26; number++ ){
            if(selected[number] == 1 || selected[number] == -1)
                continue;

            selected[number] = 1;
            combination(number+1, depth+1);
            selected[number] = 0;
        }


    }

    static void setVariable() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        selected = new int[26];
//        Arrays.fill(selected ,-1);



        words = new String[n];
        for(int i = 0; i< n; i++){
            words[i] = br.readLine();

            for(char c : words[i].toCharArray()){
                int idx = c - 'a';
                selected[idx] = 0;
            }
        }

        char [] needs = {'a', 'n', 't', 'i', 'c'};

        for(char c : needs)
            selected[c-'a'] = 1;
    }
}