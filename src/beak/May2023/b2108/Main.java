package beak.May2023.b2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        double total = 0.0;
        int avg = 0;
        int mid = 0;

        int max = -4001;
        int min = +4001;

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
            total += number;
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        avg = (int) Math.round(total / k);
        Arrays.sort(arr);

        int c = 1;
        int maxC = c;
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (i == k / 2) {
                mid = arr[i];
            }
            if (i != k - 1 && arr[i] == arr[i + 1]) {
                c++;
            } else {
                if (maxC < c) {
                    list.clear();
                    list.add(arr[i]);
                    maxC = c;
                    c = 1;
                } else if (maxC == c) {
                    c = 1;
                    list.add(arr[i]);
                } else {
                    c = 1;
                }
            }
        }

        sb.append(avg).append("\n")
                .append(mid).append("\n");
        if (list.size() == 1) {
            sb.append(list.get(0)).append("\n");
        } else {
            sb.append(list.get(1)).append("\n");
        }

        sb.append(max - min);
        System.out.println(sb);
    }


}
