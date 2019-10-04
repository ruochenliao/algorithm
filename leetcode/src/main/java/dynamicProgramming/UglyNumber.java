package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class UglyNumber {
    public boolean isUgly(int num) {
        if(num <=0){
            return false;
        }
        return isUgluNumber(num, new HashMap<>());
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
}
