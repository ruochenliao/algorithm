package dynamicProgramming;

public class CountingBits {
    /**
     * brute force
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
