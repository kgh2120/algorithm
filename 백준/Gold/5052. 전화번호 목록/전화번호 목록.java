import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<TC; t++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int i = 0; i<n; i++)
                arr[i] = br.readLine();
            Arrays.sort(arr);
            String answer = "YES";
            for(int i = 0; i<n-1; i++){
                String start = arr[i];
                String phone = arr[i+1];
                if(dosePhoneNumberIsStartWith(phone,start)){
                    answer = "NO";
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    
    static boolean dosePhoneNumberIsStartWith(String phone, String start){
        int length = start.length();
        if(length > phone.length())
            return false;
        for(int i = 0; i<length; i++){
            if(phone.charAt(i) != start.charAt(i))
                return false;
        }
        return true;
            
    }
}
