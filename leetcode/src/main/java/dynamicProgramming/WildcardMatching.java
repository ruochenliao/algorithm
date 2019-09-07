package dynamicProgramming;

/**
 * dp 来做 wildcardMathcing
 * dp[i][j] : 记录从 [i, s.length() -1] 和 [j, p.length() -1] 是否匹配
 */
public class WildcardMatching {
    public boolean isMatchRecursive(String s, String p){
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return isMatch(dp, 0, 0, s, p);
    }

    public boolean isMatch(Boolean[][] dp, int sIndex, int pIndex, String s, String p){
        if(sIndex == s.length() && pIndex == p.length()){
            return true;
        }
        if(sIndex == s.length() && pIndex < p.length() && p.charAt(pIndex) == '*'){
            for(;pIndex < p.length(); pIndex++){
                if(!(p.charAt(pIndex) == '*')){
                    return false;
                }
            }
            return true;
        }
        if(sIndex >= s.length() || pIndex >= p.length()){
            return false;
        }
        if(dp[sIndex][pIndex] != null){
            return dp[sIndex][pIndex];
        }
        Boolean isMatch = false;
        if(s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?'){
            isMatch = isMatch(dp, sIndex + 1, pIndex + 1, s, p);
        }
        else if(p.charAt(pIndex) == '*'){
            isMatch = isMatch(dp, sIndex + 1, pIndex, s, p)
                    || isMatch(dp, sIndex, pIndex + 1, s, p)
                    || isMatch(dp, sIndex + 1, pIndex + 1, s, p);
        }
        dp[sIndex][pIndex] = isMatch;
        return isMatch;
    }

}
