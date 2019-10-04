package dynamicProgramming;

public class MonkHanoiTowerByStacks {

    public int minMoveByHanoi(int n){
        if(n <= 0){
            return 0;
        }
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = 2 * dp[i-1] + 1;
        }
        return dp[n];
    }
}
