package beak.Jul2023.p17298;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_LinkedList {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        LinkedList<Element> pq = new LinkedList<>();

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            int target = Integer.parseInt(st.nextToken());
            arr[i] = -1;
            while(!pq.isEmpty() && pq.peekLast().value < target){
                Element e = pq.removeLast();
                arr[e.idx] = target;
            }
            pq.add(new Element(i,target));
        }

        for(int num : arr){
            if(num == 0)
                num = -1;
            sb.append(num).append(" ");
        }

        System.out.println(sb);

        



    }
    static class Element {
        int idx;
        int value;

        public Element(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}