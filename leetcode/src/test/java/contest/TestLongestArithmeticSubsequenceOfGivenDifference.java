package contest;


public class TestLongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args){
        LongestArithmeticSubsequenceOfGivenDifference difference = new LongestArithmeticSubsequenceOfGivenDifference();
        int[] arr = {3,4,-3,-2,-4};
        int diff = -5;
        int result = difference.longestSubsequence(arr, diff);
        System.out.println(result);
        int result2 = difference.longestSubsequenceHashMap(arr, diff);
        System.out.println(result2);
    }
}
