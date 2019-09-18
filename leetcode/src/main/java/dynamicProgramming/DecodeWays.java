package dynamicProgramming;

public class DecodeWays {
    /**
     * cnt[i] 代表 0 到 i decode 的数量
     * if(s.charAt(i) 是 1 到 9){
     *      cnt[i] = cnt[i-1]
     * }
     * if(s.charAt(i-1, i) 是 10 到 26){
     *     cnt[i] += cnt[i-2];
     * }
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] cnt = new int[n];
        int s1 = s.charAt(0) - '0';
        cnt[0] = (s1 > 0 && s1 <= 9)? 1:0;
        if(n == 1){
            return cnt[0];
        }
        int sFirst = s.charAt(1) - '0';
        int sSecond = (s.charAt(0) - '0') * 10 + sFirst;
        if(sFirst > 0 && sFirst <= 9){
            cnt[1] = cnt[0];
        }
        if(sSecond >= 10 && sSecond <= 26){
            cnt[1] += 1;
        }
        for(int i = 2; i < n; i++){
            int first = s.charAt(i) - '0';
            int second = (s.charAt(i-1) - '0') * 10 + first;
            if(first > 0 && first <= 9){
                cnt[i] = cnt[i-1];
            }
            if(second >= 10 && second <= 26){
                cnt[i] += cnt[i-2];
            }
        }
        return cnt[n-1];
    }
}
