package dynamicProgramming;

public class TestLongestIncreasingSubsequence {
    public static void main(String[] arg){
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] arr = {10,9,2,5,3,7,101,18};
        int result = subsequence.lengthOfLIS(arr);
        System.out.println(result);
        int result2 = subsequence.lengthOfLISIterative(arr);
        System.out.println(result2);
    }
}
