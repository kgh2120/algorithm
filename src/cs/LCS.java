package cs;

class LCS {
    String a = "ABCDEF";
    String b = "GBCDFE";
    Integer[][] memo = new Integer[a.length()][b.length()];

    public void solution() throws Exception {
        System.out.println(LCS(a.length()-1,b.length()-1));
    }

    public int LCS(int i, int j) {
        if(i <0 || j <0)
            return 0;

        if(memo[i][j] != null)
            return memo[i][j];

        if(a.charAt(i) == b.charAt(j))
            memo[i][j] = LCS(i-1,j-1) + 1;
        else
            memo[i][j] = Math.max(LCS(i-1,j), LCS(i,j-1));

        return memo[i][j];
    }


    public static void main(String[] args) throws Exception {
        new LCS().solution();
    }
}