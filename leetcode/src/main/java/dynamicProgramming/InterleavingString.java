package dynamicProgramming;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }
    /**
     *
     * @param s1
     * @param s2
     * @param s3
     * @param index1
     * @param index2
     * @param index3
     * @return
     */
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
}
