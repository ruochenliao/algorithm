package data.structure;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 9, 3, 5, 5};
        List<Integer> res = findDuplicate(arr);
        System.out.println(res);
    }

    private static List<Integer> findDuplicate(int[] arr) {
        if(arr == null || arr.length == 0){
            return null;
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> result = Lists.newArrayList();
        for(int i:arr){
            if(!set.add(i)){
                result.add(i);
            }
        }
        return result;
    }
}
