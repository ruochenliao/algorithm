package dynamicProgramming;

/**
 * 长度为 length 的刚才能被切成 长度为 1,2,3 ... length 的钢材
 * 长度为 1 的钢条,能卖出的价格是 p[1]
 * 长度为 2 的钢条,能卖出的价格是 p[2]
 * 。。。
 * 长度为 i 的钢条, 能卖出的价格是 p[i]
 *
 * 求怎么分， 能切割钢条卖出最贵的价格, 求长度为 length 的钢条能卖出的最贵的价格
 */
public class CuttingRod {
    public int maxProfitsOfCutRod(int length, int[] p){
        int[] dp = new int[length + 1];
        for(int i = 1; i < length + 1; i++){
            int max = 0;
            dp[1] = p[0];
            for(int j = 1; j <= i; j++){
                if(i == j){
                    //长度为 i = j 的钢材, 卖出的价格是 p[j-1]
                    max = Math.max(max, p[i-1]);
                }
                else{
                    //长度为 j 的钢材, 卖出的价格是 p[i-1 - 1]
                    max = Math.max(max, dp[j] + p[i - j - 1]);
                }

            }
            dp[i] = max;
        }
        return dp[length];
    }
}
