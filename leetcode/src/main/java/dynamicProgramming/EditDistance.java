package dynamicProgramming;

public class EditDistance {
    /**
     * recursive
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceRecursive(String word1, String word2) {
        return minDistanceRecursive(word1, word2, 0, 0);
    }
    public int minDistanceRecursive(String word1, String word2, int index1, int index2){
        if(index1 == word1.length() && index2 == word2.length()){
            return 0;
        }
        if(index1 == word1.length()){
            return word2.length() - index2;
        }
        if(index2 == word2.length()){
            return word1.length() - index1;
        }
        if(word1.charAt(index1) == word2.charAt(index2)){
            return minDistanceRecursive(word1, word2, index1+1, index2+1);
        }
        else{
            return 1 + Math.min(minDistanceRecursive(word1, word2, index1, index2+1)
                    , Math.min(minDistanceRecursive(word1, word2, index1+1, index2),
                            minDistanceRecursive(word1, word2, index1+1, index2+1)));
        }
    }
    /**
     * recursive dp[i][j] i 到 j 最少需要步
     * dp[i][j]
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceRecursiveDp(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return minDistanceRecursiveDp(word1, word2, 0, 0, dp);
    }
    public int minDistanceRecursiveDp(String word1, String word2, int index1, int index2, Integer[][] dp){
        if(index1 == word1.length() && index2 == word2.length()){
            return 0;
        }
        if(index1 == word1.length()){
            return word2.length() - index2;
        }
        if(index2 == word2.length()){
            return word1.length() - index1;
        }
        if(dp[index1][index2] != null){
            return dp[index1][index2];
        }
        int distance = 0;
        if(word1.charAt(index1) == word2.charAt(index2)){
            distance = minDistanceRecursiveDp(word1, word2, index1+1, index2+1, dp);
        }
        else{
            distance = 1 + Math.min(minDistanceRecursiveDp(word1, word2, index1, index2+1, dp)
                    , Math.min(minDistanceRecursiveDp(word1, word2, index1+1, index2, dp),
                            minDistanceRecursiveDp(word1, word2, index1+1, index2+1, dp)));
        }
        dp[index1][index2] = distance;
        return distance;
    }
    /**
     *
     * dp[i+1][j+1] 表示 0 到 i  和 0 到 j 需要 dp[i+1][j+1] 步操作
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j < n+1; j++){
            dp[0][j] = j;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
                   dp[i+1][j+1] = 1 + Math.min( dp[i][j],Math.min( dp[i][j+1], dp[i+1][j] ));
                }
            }
        }
        return dp[m][n];
    }
}
