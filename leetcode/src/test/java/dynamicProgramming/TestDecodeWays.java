package dynamicProgramming;

public class TestDecodeWays {
    public static void main(String[] args){
        String str = "110";
        DecodeWays decodeWays = new DecodeWays();
        int cnt = decodeWays.numDecodings(str);
        System.out.println(cnt);
    }
}
