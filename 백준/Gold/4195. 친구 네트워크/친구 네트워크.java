import java.util.*;
import java.io.*;
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Map<String,Integer> nameToIndexConverter;
    static List<Counter> parents;
    static List<Counter> acc;
    static int index;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요

        int TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            nameToIndexConverter = new HashMap<>();
            parents = new ArrayList<>();
            acc = new ArrayList<>();
            index = 0;

            int f = Integer.parseInt(br.readLine());

            for(int i = 0; i<f; i++){
                st = new StringTokenizer(br.readLine());

                String name1 = st.nextToken();
                String name2 = st.nextToken();


                Integer name1Index = nameToIndexConverter.get(name1);
                if(name1Index == null){
                    nameToIndexConverter.put(name1, index);
                    name1Index = index;
                    parents.add(new Counter(index));
                    acc.add(new Counter(1));
                    index++;
                }

                Integer name2Index = nameToIndexConverter.get(name2);

                if(name2Index == null){
                    nameToIndexConverter.put(name2, index);
                    name2Index = index;
                    parents.add(new Counter(index));
                    acc.add(new Counter(1));
                    index++;
                }

                int union = union(name1Index, name2Index);
                sb.append(union).append("\n");


            }

        }

        System.out.println(sb);
    }
    
    static int union(int left, int right){
        int ll = find(left);
        int rr = find(right);
        if(ll == rr)
            return acc.get(ll).value;
        
        if(ll<rr){
            parents.get(rr).value = ll;
            acc.get(ll).value += acc.get(rr).value;
            return acc.get(ll).value;
        } else {
            parents.get(ll).value = rr;
            acc.get(rr).value += acc.get(ll).value;
            return acc.get(rr).value;
        } 
        
        
    }

    static int find(int i){
        if(parents.get(i).value == i)
            return i;
        return parents.get(i).value = find(parents.get(i).value);
    }

    static class Counter{
        int value;

        public Counter(int value) {
            this.value = value;
        }
    }

}
