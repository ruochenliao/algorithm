package dynamicProgramming;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int height = triangle.size();
        int width = triangle.get(height-1).size();
        int[] dp = new int[width];
        for(int i = 0; i < width; i++){
            dp[i] = triangle.get(height-1).get(i);
        }
        for(int i = height - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
