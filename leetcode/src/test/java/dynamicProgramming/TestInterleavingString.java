package dynamicProgramming;

public class TestInterleavingString {
    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString interleaving = new InterleavingString();
        boolean result = interleaving.isInterleave(s1, s2, s3);
        System.out.println(result);
    }
}
