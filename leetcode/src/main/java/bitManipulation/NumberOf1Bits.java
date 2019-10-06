package bitManipulation;

public class NumberOf1Bits {
    /**
     * TLE: Time Limit Exceeded
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while(n!= 0){
            if((n & 1) == 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    /**
     * n       = 11110100
     * n-1     = 11110011
     * n*(n-1) = 11110000 : 把 n 的最后一位数移除掉了
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
