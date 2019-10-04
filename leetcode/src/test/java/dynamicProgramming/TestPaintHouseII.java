package dynamicProgramming;

public class TestPaintHouseII {
    public static void main(String[] args){
        PaintHouseII paintHouseII = new PaintHouseII();
        int[][] arr = {
                {1,5,3},
                {2,9,4}
        };
        int result = paintHouseII.minCostIterative(arr);
        System.out.println(result);
    }
}
