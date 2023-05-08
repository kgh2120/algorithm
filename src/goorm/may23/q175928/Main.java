package goorm.may23.q175928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        char[] goorm = br.readLine().toCharArray();

        int count = 0;
        int nOfStrike = 0;
        boolean[] strikes = new boolean[4];
        while(nOfStrike(strikes) < 4){
            count++;
            boolean hasBall = false;
            List<Integer> notStrikeIdx = new ArrayList<>();
            for(int i = 0; i<4; i++){
                // strike
                if(goorm[i] == answer.charAt(i)){
                    strikes[i] = true;
                    continue;
                }else if(answer.contains(goorm[i]+"")){ // ball
                    hasBall = true;
                }else{ // fail
                    char f = fail(goorm[i]);
                    while(contains(goorm,f)){
                        f = fail(f);
                    }
                    goorm[i] = f;

                }
                notStrikeIdx.add(i);
            }
            if(hasBall){
                int first = notStrikeIdx.get(0);
                char last = goorm[notStrikeIdx.get(notStrikeIdx.size()-1)];

                for(int i = notStrikeIdx.size()-2; i>=0; i--){
                    goorm[notStrikeIdx.get(i+1)] = goorm[notStrikeIdx.get(i)];
                }
                goorm[first] = last;
            }

        }
        System.out.println(count);
    }

    private static char fail(int k){
        k -= 48;
        return (char)(((k + 1) % 10) + 48);
    }
    private static boolean contains (char[] seq, char c){
        for(char s : seq){
            if(s == c)
                return true;
        }
        return false;
    }

    private static int nOfStrike(boolean[]visited){
        int count = 0;
        for(boolean isVisited : visited){
            if(isVisited) count++;
        }
        return count;
    }
}