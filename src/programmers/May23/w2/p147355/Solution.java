package programmers.May23.w2.p147355;

class Solution {
    // sliding window 하면 어떨까?
    public int solution(String t, String p) {

        int answer = 0;

        int length = p.length();
        int l = 0;
        int r = length;

        long target = Long.parseLong(p);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <r; i++)
            sb.append(t.charAt(i));

        long f = Long.parseLong(sb.toString());
        if(f <= target)
            answer++;



        while(r <t.length()){
            sb.deleteCharAt(0);
            sb.append(t.charAt(r++));
            f = Long.parseLong(sb.toString());

            if(f <= target)
                answer++;
        }




        return answer;
    }
}