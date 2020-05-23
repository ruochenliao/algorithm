package data.structure;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class MergeKthList {
    public List<Integer> mergeKthList(List<List<Integer>> lists){
        if(lists == null || lists.size() == 0){
            return new ArrayList<>(0);
        }
        return helper(lists, 0, lists.size() - 1);
    }

    List<Integer> helper(List<List<Integer>> lists, int left, int right){
        if(left > right){
            return new ArrayList<>(0);
        }
        if(left == right){
            return lists.get(left);
        }

        int mid = (left + right)/2;

        List<Integer> l1 = helper(lists, left, mid);
        List<Integer> l2 = helper(lists, mid + 1, right);
        return mergeTwoList(l1, l2);
    }



    public List<Integer> mergeTwoList(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        int k = 0, i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                result.add(l1.get(i));
                i++;
            } else {
                result.add(l2.get(j));
                j++;
            }
            k++;
        }

        while (i < l1.size()) {
            result.add(l1.get(i++));
        }

        while (j < l2.size()) {
            result.add(l2.get(j++));
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> l1 = Lists.newArrayList(1,5,6,10);
        List<Integer> l2 = Lists.newArrayList(2,4,7);
        List<Integer> l3 = Lists.newArrayList(0,3,8,9);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1); lists.add(l2); lists.add(l3);
        MergeKthList mergeKthList = new MergeKthList();
        List<Integer> result = mergeKthList.mergeKthList(lists);

        result.forEach(System.out::println);
    }
}
