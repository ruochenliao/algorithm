package data.structure;

import Utils.ListNode;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeTwoList {
    public List<Integer> mergeTwoList(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new LinkedList<>();
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

    public ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummy = new ListNode<>(0);
        ListNode<Integer> temp = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1 != null){
            temp.next = l1;
        }

        if(l2 != null){
            temp.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(1); l1.add(3); l1.add(5); l1.add(6);
        l2.add(2); l2.add(4); l2.add(7);

        MergeTwoList mergeTwoList = new MergeTwoList();
//        List<Integer> result = mergeTwoList.mergeTwoList(l1, l2);
//        result.forEach(System.out::println);

        System.out.println();
        List<Integer> list1 = Lists.newArrayList(1, 5, 6, 10);
        List<Integer> list2 = Lists.newArrayList(2, 4, 7);
        List<Integer> result1 = mergeTwoList.mergeTwoList(list1, list2);
        result1.forEach(System.out::println);
    }
}
