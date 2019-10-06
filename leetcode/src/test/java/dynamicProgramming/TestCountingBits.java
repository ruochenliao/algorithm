package dynamicProgramming;

import java.util.Arrays;

public class TestCountingBits {
    public static void main(String[] args){
        int n = 5;
        CountingBits bits = new CountingBits();
        int[] result1 = bits.countBits(n);
        for(int i:result1){
            System.out.print(i+",");
        }
        System.out.println();
        int[] result2 = bits.countBitsDp(n);
        for(int i:result2){
            System.out.print(i+",");
        }
    }
}
