package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class UglyNumumberII {
    /**
     * dp 一个一个判断是否是 Ugly num
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }
        int i = 0;
        int count = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        while(count != n){
            i++;
            if(isUgluNumber(i, map)){
                count++;
            }
        }
        return i;
    }
    private boolean isUgluNumber(int num, Map<Integer, Boolean> map){
        if(num == 1){
            return true;
        }
        if(map.get(num)!= null){
            return map.get(num);
        }
        int result;
        if(num % 2 == 0){
            result = num / 2;
        }
        else if(num % 3 == 0){
            result = num / 3;
        }
        else if(num % 5 == 0){
            result = num / 5;
        }
        else{
            map.put(num, false);
            return false;
        }
        boolean isUgly = isUgluNumber(result, map);
        map.put(num, isUgly);
        return isUgly;
    }

    /**
     * 从已知推测未知
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for(int i = 1; i < n + 1; i++){
            nums[i] = Math.min(5 * nums[i5], Math.min(2 * nums[i2], 3 * nums[i3]));
            if(nums[i] == 5 * nums[i5]){
                i5++;
            }
            if(nums[i] == 3 * nums[i3]){
                i3++;
            }
            if(nums[i] == 2 * nums[i2]){
                i2++;
            }
        }
        return nums[n-1];
    }
}
