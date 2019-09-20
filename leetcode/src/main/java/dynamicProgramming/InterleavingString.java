package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    /**
     * recursive
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }
    public boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3) {
        if((index1 == s1.length() && index2 == s2.length())
                && index3 == s3.length()){
            return true;
        }
        boolean isMatch1 = false;
        boolean isMatch2 = false;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
            isMatch1 = isInterleave(s1, s2, s3, index1+1, index2, index3+1);
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
            isMatch2 = isInterleave(s1, s2, s3, index1, index2+1, index3+1);
        }
        if(isMatch1 || isMatch2){
            return true;
        }
        return false;
    }


    class Key{
        private int index1;
        private int index2;
        private int index3;
        Key(int index1, int index2, int index3){
            this.index1 = index1;
            this.index2 = index2;
            this.index3 = index3;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            return this.index1 == key.index1
                    && this.index2 == key.index2
                    && this.index3 == key.index3;
        }

        @Override
        public int hashCode() {
            return index1 + index2 *31;
        }
    }

    /**
     * recursive with memory record dp with map record
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveDp(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Map<Key, Boolean> map = new HashMap<>();
        return isInterleave(s1, s2, s3, 0, 0, 0,map);
    }

    public boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3, Map<Key, Boolean> map) {
        if(index1 == s1.length() && index2 == s2.length() && index3 == s3.length()){
            return true;
        }
        Key key = new Key(index1, index2, index3);
        if(map.get(key) != null){
            return map.get(key);
        }
        boolean isMatch1 = false;
        boolean isMatch2 = false;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
            isMatch1 = isInterleave(s1, s2, s3, index1+1, index2, index3+1, map);
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
            isMatch2 = isInterleave(s1, s2, s3, index1, index2+1, index3+1, map);
        }
        Boolean isMatch = isMatch1 || isMatch2;
        map.put( key, isMatch);
        return isMatch;
    }

    /**
     * recursive with memory record with array record
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleaveDpWithArray(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        Boolean[][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return isInterleave(s1, s2, s3, 0, 0, 0, dp);
    }

    public boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3, Boolean[][][] dp) {
        if(index1 == s1.length() && index2 == s2.length() && index3 == s3.length()){
            return true;
        }
        if(dp[index1][index2][index3] != null){
            return dp[index1][index2][index3];
        }
        boolean isMatch1 = false;
        boolean isMatch2 = false;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
            isMatch1 = isInterleave(s1, s2, s3, index1+1, index2, index3+1, dp);
        }
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
            isMatch2 = isInterleave(s1, s2, s3, index1, index2+1, index3+1, dp);
        }
        Boolean isMatch = isMatch1 || isMatch2;
        dp[index1][index2][index3] = isMatch;
        return isMatch;
    }
}
