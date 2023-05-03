package beak.prev.sorting;

import java.io.*;

/*
    문제 : 수 정렬하기 2
    난이도 : 실버 5
    특징 : n log n 짜리 정렬하기 문제.
           처음엔 quick sort를 썻는데, 주어진 상황이 worst case로만 줘서 n2이 떠서 실패했음.
           이후 merge sort로 했는데, sortedArray를 계속 생성하는 overload로 인해서 시간이 늦게 나온 것 같다.
           static variable로 사용하거나, 밖에서 생성하고 매개변수로 넣어주는 식으로 해야 할 듯.
           StringBuilder는 실험을 해봤는데 그렇게 효능이 있는지는 모르겠음.
 */
public class p2751 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        try {

            int loop =  Integer.parseInt(br.readLine());
            int[] arr = new int[loop];
            int[] sortedArr = new int[loop];
            for (int i = 0; i < loop; i++)
                arr[i] = Integer.parseInt(br.readLine());

            mergeSort(arr,sortedArr, 0, arr.length - 1);

//            for (int i = 0; i < loop; i++)
//                result.append(arr[i]+"\n");
//            bw.write(String.valueOf(result));
            for (int i = 0; i < loop; i++)
                bw.write(Integer.toString(arr[i])+"\n");
//            bw.write(String.valueOf(result));

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void mergeSort(int[]arr,int[]sortedArr, int start, int end){
        if(start<end){
            int q = (start+end)/2;
            mergeSort(arr,sortedArr,start,q);
            mergeSort(arr,sortedArr,q+1,end);
            merge(arr,sortedArr, start, q, end);
        }
    }

    private static void merge(int[]arr,int[]sortedArr, int start, int q, int end){

        int i = start;
        int j = q+1;
        int k = start;

        while(i<=q && j<= end)
            if(arr[i] < arr[j])
                sortedArr[k++] = arr[i++];
            else
                sortedArr[k++] = arr[j++];


        // 남은거 처리해주기
        while(i<=q)
            sortedArr[k++] = arr[i++];
        while(j<=end)
            sortedArr[k++] = arr[j++];

        for(int p = start; p<=end; p++)
            arr[p] = sortedArr[p];


    }
}
