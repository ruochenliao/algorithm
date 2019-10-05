package dynamicProgramming;

public class TestNumMatrix {
    public static void main(String[] args){
        int[][] arr = {{-4, -5}};
        NumMatrix matrix = new NumMatrix(arr);
        int result = matrix.sumRegion(1,1,2,2);
        System.out.println(result);
    }
}
