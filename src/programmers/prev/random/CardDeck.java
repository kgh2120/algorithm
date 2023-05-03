package programmers.prev.random;

import java.io.IOException;

public class CardDeck {

    public String solution(String[] card1, String[] card2, String[] goal) {
        int l = 0;
        int r = 0;
        int i = 0;
        while(i < goal.length){
            String g = goal[i];
            String left = "";
            String right = "";
            if(l != card1.length)
                left = card1[l];
            if(r != card2.length)
                right = card2[r];

            if(g.equals(left))
                l++;
            else if(g.equals(right))
                r++;
            else
                return "No";
            i++;
        }
        return "Yes";
    }



    public static void main(String[] args) throws IOException {

        String [][] a = {{"09:10", "10:10"}, {"10:20", "12:20"}};
//        System.out.println(((new Solution().solution("aukks", "wbqd", 5))));

    }
}
