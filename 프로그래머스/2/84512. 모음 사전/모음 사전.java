import java.util.*;
class Solution {
    public int solution(String word) {
        int answer = 0;
        
        List<String> dic = new ArrayList<>(5*5*5*5*5);
        
        char[] arr = {'A','E','I','O','U'};
        
        for(int a = 0; a<5; a++){
            String aa = arr[a] + "";
            dic.add(aa);
            
            for(int b = 0; b<5; b++){
                String bb = aa+arr[b];
                dic.add(bb);
                for(int c = 0; c< 5; c++){
                    String cc = bb+arr[c];
                    dic.add(cc);
                    for(int d = 0; d<5; d++){
                        String dd = cc+arr[d];
                        dic.add(dd);
                        for(int e =0; e<5; e++){
                            dic.add(dd+arr[e]);
                        }
                    }
                }
            }
        }
        
        answer = Collections.binarySearch(dic, word) + 1;
        
        
        return answer;
    }
}