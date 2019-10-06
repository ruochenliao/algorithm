package dynamicProgramming;

public class CountNumberWithUniqueDigits {
    /**
     * n = 0, sum = 1;
     * n = 1, sum = 10;
     * n = 2, sum = 10 + 9 * 9; //对于一个两位数, 第一位数从 1 到 9 中取, 第二位数从 0 到 9 中取, 但是不能和前一位重
     * n = 3, sum = 10 + 9 * 9 * 8; //对于一个三位数, 第一位数从 1 到 9 中取, 第二位数从 0 到 9 中取, 但是不能有重的, 第三位从 0 到 9 中取, 但不能和前两位重
     * n = 4, sum = 10 + 9 * 9 * 8 * 7;
     * ...
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        int sum = 10;
        int multiply = 9;
        for(int i = 9; i >= 9 - (n-2) && i > 0; i--){
            multiply = multiply * i;
            sum = sum + multiply;
        }
        return sum;
    }
}
