package data.structure;

import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class KSmallestPairs {
    public static void main(String[] args) {
        int[]arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};
        List<List<Integer>> res1 = getMinSumByHeap(arr1, arr2, 3);
        res1.forEach(it-> System.out.println(it));

    }

    /**
     * 给定两个整数数组 arr1/arr2 和一个整数 n, 返回两个数组中元素的加和最小的 n 个组合.
     * O(n^2 )
     * 暴力方法
     * @param arr1
     * @param arr2
     * @param n
     * @return
     */
    public static List<List<Integer>> getMinSumByHeap(int[] arr1, int[] arr2, int n) {
        List<List<Integer>> result = new ArrayList<>(n);
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() + b.getValue());
        for (int e1 : arr1) {
            for (int e2 : arr2) {
                queue.add(new Pair<>(e1, e2));
            }
        }

        for (int i = 0; i < n; i++) {
            Pair<Integer, Integer> temp = queue.poll();
            result.add(Lists.newArrayList(temp.getKey(), temp.getValue()));
        }

        return result;
    }
}
