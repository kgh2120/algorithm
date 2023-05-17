package programmers.May23.w3.p118666;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // RT, CF, JM, AN
        // survey를 꺼낸다. 1-7 2-6 3-5 4
        // 점수 획득... 5~7이면 뒤에가, 1~3이면 앞에가 얻는다.
        // 점수는 4-x의 절대값 1점 : 3,5 2점 2,6 3점 1,7
        // 크기에 따라서 후자한테 점수를 넣어준다.
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i< survey.length; i++){
            String s = survey[i];
            int score = choices[i];
            if(score > 4)
                map.put(s.charAt(1), map.getOrDefault(s.charAt(1),0) + Math.abs(4-score));
            else
                map.put(s.charAt(0), map.getOrDefault(s.charAt(0),0) + Math.abs(4-score));

        }

        // 그 다음에 순서대로 꺼내서 비교
        StringBuilder sb = new StringBuilder();
        // RT, CF, JM, AN
        append(map,sb,'R','T');
        append(map,sb,'C','F');
        append(map,sb,'J','M');
        append(map,sb,'A','N');



        String answer = sb.toString();
        return answer;
    }
    private void append(Map<Character,Integer>map, StringBuilder sb, char left, char right){
        if(map.getOrDefault(left,0) < map.getOrDefault(right,0))
            sb.append(right);
        else
            sb.append(left);
    }
}