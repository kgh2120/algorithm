package programmers.prev.stackq;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();
        int index = 0;
        for(int p : priorities){
            q.add(new Node(p,index++));
        }

        Arrays.sort(priorities);

        int reverseIndex = priorities.length-1;
        while(answer != priorities.length){
            Node n = q.poll();

            if(priorities[reverseIndex] == n.weight){
                answer++;
                reverseIndex--;
            }
            else {
                q.add(n);
                continue;
            }

             if (n.location == location)
                return answer;
        }
        return answer;
    }


    class Node {
        int weight;
        int location;

        Node(int weight, int location){
            this.weight = weight;
            this.location = location;
        }
    }




    public static void main(String[] args) {

       int [] a = {1, 1, 9, 1, 1, 1};
       int b = 0;

        System.out.println((new Printer().solution(a,b)));
    }
}