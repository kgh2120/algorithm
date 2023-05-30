package programmers.May23.p148653;

class Solution {
    int min = Integer.MAX_VALUE;
    public int solution(int storey) {
        findPath(storey,0);
        return min;
    }

    private void findPath(int n, int w){
        if(w > min)
            return;

        if(isTenth(n)) { // 10의 제곱수여야 함.
            System.out.println(n);
            min = Math.min(min,w+1);
            return;
        }

        int t = n/10;
        int e = n%10;
        if(t < 5){
            if(e<=5){
                min = Math.min(min, w + t + e);
                return;
            }else{

                min = Math.min(min, t+1 + w + 10- e);
            }
        }else{
            findPath(t,w + e);
            findPath(t+1, w + 10 - (e));
        }
    }
    private boolean isTenth(int n){
        if(n%10 != 0)
            return false;

        while(n>0){
            n /= 10;
            if(n %10 != 0)
                return false;
        }
        return true;
    }
}