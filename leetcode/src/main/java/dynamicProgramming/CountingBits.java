package dynamicProgramming;

/**
 * 338. Counting Bits
 * Medium
 *
 * 2269
 *
 * 143
 *
 * Add to List
 *
 * Share
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {
    /**
     * brute force O(n^2)
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = getNumOfBits(i);
        }
        return res;
    }

    private int getNumOfBits(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n / 2;
        }
        return count;
    }

    /**
     * O(n)
     * 减少 i 的最低一位的办法是 i & (i-1)
     * i            = 11110100
     * i - 1        = 11110011
     * i & (i - 1)  = 11110000
     *
     * @param num
     * @return
     */
    public int[] countBitsDp(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
