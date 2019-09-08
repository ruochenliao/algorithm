package dynamicProgramming;

public class TestMinimumPathSum {
    public static void main(String[] args){
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] arr = {
                {0,1},
                {1,0}
        };
        int result = minimumPathSum.minPathSum(arr);
        System.out.println(result);
    }
}
