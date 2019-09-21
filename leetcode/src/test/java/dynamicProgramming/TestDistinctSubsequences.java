package dynamicProgramming;

public class TestDistinctSubsequences {
    public static void main(String[] args){
        DistinctSubsequences subsequences = new DistinctSubsequences();
        String s = "babgbag";
        String t = "bag";
        int result = subsequences.numDistinct(s, t);
        System.out.println(result);
    }
}
