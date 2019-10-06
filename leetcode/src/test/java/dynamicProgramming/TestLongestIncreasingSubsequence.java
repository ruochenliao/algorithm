package dynamicProgramming;

public class TestLongestIncreasingSubsequence {
    public static void main(String[] arg){
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] arr = {0, 8, 4, 12, 2};
        int result = subsequence.lengthOfLIS(arr);
        System.out.println(result);
        int result2 = subsequence.lengthOfLISIterative(arr);
        System.out.println(result2);
        int result3 = subsequence.lengthOfLISBinarySearch(arr);
        System.out.println(result3);
    }
}
