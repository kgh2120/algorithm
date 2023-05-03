package programmers.prev.stackq;

public class CorrectBracket {

    boolean solution(String s) {
        boolean answer = true;

        int size = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                size++;
                continue;
            }

            if(size <=0)
                return false;
            size--;

        }

        return size==0;
    }




    public static void main(String[] args) {

       String a = "()()";

        System.out.println((new CorrectBracket().solution(a)));
    }
}