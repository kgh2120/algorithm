public class Solution {

    public int solution(int[] common) {

        // 등차인가?

        int m = common[1] - common[0];


        for (int i = 2; i <= common.length-1; i++) {
            if (common[i] - common[i - 1] != m) {
                m = 0;
                break;
            }

        }

        if(m != 0)
            return common[common.length-1] + m;

        // 등비인가??
        int k = common[1] / common[0];
        for (int i = 2; i <= common.length-1; i++) {
            if (common[i] / common[i - 1] != k) {
                k = 0;
                break;
            }
        }

        if(k != 0)
            return common[common.length-1] * k;


        int answer = 0;
        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        int[] array = {1,2,3,4};

        System.out.println(s.solution(array));
    }
}