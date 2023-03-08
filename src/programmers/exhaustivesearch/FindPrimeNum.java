package programmers.exhaustivesearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int leg = numbers.length();
        find(numbers,"",0,leg,new boolean[leg]);
        return set.size();
    }

    public void find(String numbers, String part, int depth, int last, boolean[]visited){
        if(last == depth){
            if(part.equals(""))
                return;

            int num = Integer.parseInt(part);
            if(isPrimeNum(num))
                set.add(num);
            return;
        }

        for(int i = 0; i<last; i++){
            if(!visited[i]){
                visited[i] = true;
                find(numbers,part + numbers.charAt(i), depth+1, last, visited);
                find(numbers,part, depth+1, last, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrimeNum(int num){
        if(num <= 1)
            return false;

        for(int i = 2; i<= Math.sqrt(num); i++)
            if(num%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) {



        System.out.println(((new FindPrimeNum().solution("17"))));
    }
}
