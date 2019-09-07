package dynamicProgramming;

public class TestWildCardDp {
    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        boolean result = wildcardMatching.isMatchRecursive("ab", "?*");
        System.out.println(result);
    }
}
