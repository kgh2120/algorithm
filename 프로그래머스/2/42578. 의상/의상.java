import java.util.*;
/*
    combination으로 옷의 종류를 구하고, 구해진 경우에서 각 옷의 종류 별 갯수를 곱하면 경우의 수가 구해진다.
*/

class Solution {
    
    Map<String, Counter> clothKinds = new HashMap<>();
    List<String> clothIndexMapper = new ArrayList<>();
    
    int answer;
    
    public int solution(String[][] clothes) {
        
        
        for(int i = 0; i<clothes.length; i++){
            String type = clothes[i][1];
            
            Counter c = clothKinds.get(type);
            
            if(c == null){
                c = new Counter();
                clothKinds.put(type, c);
                clothIndexMapper.add(type);
            }
            c.v++;
        }
        if(clothIndexMapper.size() == 30){
            return (int)Math.pow(2,30) -1;
        }
        
        comb(0, 1);
        
        return answer-1;
    }
    
    private void comb(int depth, int val){
        if(depth == clothIndexMapper.size()){
            answer += val;
            return;
        }
        
        comb(depth+1, val * clothKinds.get(clothIndexMapper.get(depth)).v);
        comb(depth+1, val);

    }
    
    class Counter{
        int v;
    }
}