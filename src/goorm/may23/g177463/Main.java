package goorm.may23.g177463;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        final int mod = 100_000_007;
        long answer = 3;
        for(int i = 1; i < n; i++){
            answer *= 2;
            answer %= mod;
        }
        System.out.println(answer);
    }
}