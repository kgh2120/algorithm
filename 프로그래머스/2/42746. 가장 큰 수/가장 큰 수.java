import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String [] str = new String[numbers.length];
        for(int i = 0; i<numbers.length;i++)
            str[i] = Integer.toString(numbers[i]);
        
       Arrays.sort(str, new Comparator<String>(){
           @Override
           public int compare(String o1, String o2){
               int a = Integer.parseInt(o1+o2);
               int b = Integer.parseInt(o2+o1);
               return Integer.compare(a,b) * -1;
           }
       });
        
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : str)
            sb.append(s);
        
        
        answer = sb.toString();
        if(answer.charAt(0) == '0')
            answer = "0";
       
        return answer;
    }
    
  
}