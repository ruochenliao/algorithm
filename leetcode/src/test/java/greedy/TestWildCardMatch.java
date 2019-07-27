package greedy;

import greedy.WildcardMatching;
import org.junit.Assert;

public class TestWildCardMatch {
    public static void main(String[] args){
        WildcardMatching wildcardMatching = new WildcardMatching();
        boolean result1 = wildcardMatching.isMatch("adceb","*a*b");
        boolean result2 = wildcardMatching.isMatch("cb","?a");
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
    }
}
