package dynamicProgramming;

public class TestUniquePathII {
    public static void main(String[] args){
        UniquePathII obstacles = new UniquePathII();
        int[][] dp = {
                {0,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int[][] dp1 = {
                {1}
        };
        int result = obstacles.uniquePathsWithObstacles(dp);
        System.out.println(result);
    }
}
