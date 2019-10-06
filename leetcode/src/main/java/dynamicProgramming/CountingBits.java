package dynamicProgramming;

public class CountingBits {
    /**
     * brute force O(n^2)
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0; i <= num; i++){
            res[i] = getNumOfBits(i);
        }
        return res;
    }
    private int getNumOfBits(int n){
        int count = 0;
        while(n!= 0){
            if((n & 1) == 1){
                count++;
            }
            n = n/2;
        }
        return count;
    }

    /**
     * O(n)
     * 减少 i 的最低一位的办法是 i & (i-1)
     * i            = 11110100
     * i - 1        = 11110011
     * i & (i - 1)  = 11110000
     *
     * @param num
     * @return
     */
    public int[] countBitsDp(int num) {
        int[] dp = new int[num+1];
        for(int i = 1; i <= num; i++){
            dp[i] = dp[i&(i-1)] + 1;
        }
        return dp;
    }
}
