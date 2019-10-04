package dynamicProgramming;

public class TestUglyNumberII {
    public static void main(String[] args){
        int n = 10;
        UglyNumumberII numumberII = new UglyNumumberII();
        int result = numumberII.nthUglyNumber(n);
        System.out.println(result);
        int result1 = numumberII.nthUglyNumber1(n);
        System.out.println(result1);
    }
}
