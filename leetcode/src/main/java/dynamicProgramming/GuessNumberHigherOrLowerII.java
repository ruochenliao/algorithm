package dynamicProgramming;

/**
 * 375. Guess Number Higher or Lower II
 * Medium
 *
 *
 * Favorite
 *
 * Share
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 *
 * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *
 * Example:
 *
 * n = 10, I pick 8.
 *
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *
 * Game over. 8 is the number I picked.
 *
 * You end up paying $5 + $7 + $9 = $21.
 * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        Integer[][] dp = new Integer[n+1][n+1];
        return getMoneyAmount(1, n, dp);
    }

    /**
     * 这里面最差的 scenario 的意思是 select 每个数, 但是都没有选中;
     * 在这些最差的 scenario 中, 找最少花的钱 to guarantee a win.
     * @param low
     * @param high
     * @param dp
     * @return 从 low 到 high 以最低的钱dp[i][j] 去保证最差的 scenario
     */
    private int getMoneyAmount(int low, int high, Integer[][] dp){
        if(low >= high){
            return 0;
        }
        if(dp[low][high] != null){
            return dp[low][high];
        }
        int pivot = (low + high)/2;
        int result = Integer.MAX_VALUE;
        for(int i = pivot; i < high + 1; i++){
            int maxCost = Math.max(getMoneyAmount(i+1, high, dp), getMoneyAmount(low, i-1, dp)) + i;
            result = Math.min(result, maxCost);
        }
        dp[low][high] = result;
        return result;
    }
}
