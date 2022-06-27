package Inflearn.bfsdfs;

import java.util.Scanner;

public class Inflearn_8_1_SameTotalSubSet {

    int[] groupY, groupN;
    int[] nOfV;
    boolean same = false;

    public void init(int n) {
        nOfV = new int[n];
        groupY = new int[n];
        groupN = new int[n];
    }

    public boolean isSame() {
        int totalY = 0;
        int totalN = 0;
        for (int i : groupY) {
            totalY += i;
        }

        for (int i : groupN) {
            totalN += i;
        }

        return totalY == totalN;
    }

    public void DFS(int index, int last) {
        if(same) return;
        if (index == last) {
            if (isSame()) {
                same = true;
            }
            return;
        }

        groupY[index] = nOfV[index]; // nOfV[index]를 포함한 경우
        DFS(index+1,last);

        // 포함하지 않은 경우
        groupY[index] = 0;
        groupN[index] = nOfV[index];
        DFS(index+1,last);
        groupN[index] = 0;

    }


    public static void main(String[] args) {
        Inflearn_8_1_SameTotalSubSet m = new Inflearn_8_1_SameTotalSubSet();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        m.init(n);

        for (int i = 0; i < n; i++) {
            m.nOfV[i] = scanner.nextInt();
        }

        m.DFS(0,n);
        if(m.same)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
