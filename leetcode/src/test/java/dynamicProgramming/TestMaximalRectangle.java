package dynamicProgramming;

public class TestMaximalRectangle {
    public static void main(String[] args){
        MaximumRectangle maximumRectangle = new MaximumRectangle();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int result = maximumRectangle.maximalRectangle(matrix);
        char[][] matrix1 = {{'0','1'}};
        System.out.println(result);
        int result1 = maximumRectangle.maximalRectangle(matrix1);
        System.out.println(result1);
    }
}
