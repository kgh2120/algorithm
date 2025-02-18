import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        String prev = phone_book[0];
        for(int i = 1; i<phone_book.length; i++){
            String cur = phone_book[i];
            if(cur.startsWith(prev)){
                return false;
            }
            prev = cur;
        }
        
        return answer;
    }
}