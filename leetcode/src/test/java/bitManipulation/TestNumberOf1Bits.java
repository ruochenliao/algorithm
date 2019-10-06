package bitManipulation;

public class TestNumberOf1Bits {
    public static void main(String[] args){
        NumberOf1Bits bits = new NumberOf1Bits();
        int result = bits.hammingWeight1(2147483645);
        System.out.println(result);
        int result2 = bits.hammingWeight2(1011);
        System.out.println(result2);
    }
}
