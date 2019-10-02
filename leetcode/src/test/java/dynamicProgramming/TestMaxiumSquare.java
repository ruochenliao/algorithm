package dynamicProgramming;

public class TestMaxiumSquare {
    public static void main(String[] args){
        MaximumSquare maximumSquare = new MaximumSquare();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int result = maximumSquare.maximalSquare(matrix);
        System.out.println(result);
    }
}
