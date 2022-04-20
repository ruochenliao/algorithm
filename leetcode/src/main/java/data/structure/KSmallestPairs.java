package data.structure;

import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Find K Pair with Smallest Sums
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 *
 * 输出: [1,2],[1,4],[1,6]
 *
 * 解释: 返回序列中的前 3 对数：
 *
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 *
 * 输出: [1,1],[1,1]
 *
 * 解释: 返回序列中的前 2 对数：
 *
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 *
 * 输出: [1,3],[2,3]
 *
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 *
 *
 */
public class KSmallestPairs {
    public static void main(String[] args) {
        int[]arr1 = {1, 2, 3};
        int[] arr2 = {4, 5};
        List<List<Integer>> res1 = kSmallestPairs(arr1, arr2, 3);
        res1.forEach(it-> System.out.println(it));

    }

    /**
     *
     * 如果两个数组排序完成，那么
     * 第一小值 = arr1[0] + arr2[0]
     * 第二小值 = min(arr1[0] + arr2[1], arr1[1] + arr2[0])
     * 第三小值 = min(arr1[0] + arr2[1], arr1[0] + arr2[2], arr1[1] + arr2[0], arr1[1] + arr2[1], arr1[1] + arr2[0])
     * 需要不断把值放到 heap 中算出最小的 Pair
     *
     * @param arr1
     * @param arr2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        List<List<Integer>> result = new ArrayList<>(k);
        PriorityQueue<Integer[]> q = new PriorityQueue<>((a, b) -> a[1] + a[2] - b[1] - b[2]);
        //插入arr1 的第一个数，遍历arr2的第i 个数，和arr1 的指针0
        for(int a2: arr2){
            q.offer(new Integer[]{arr1[0], a2, 0});
        }

        while(k < 0 && !q.isEmpty()){
            k--;
            //获取最小 Pair, 插入到结果中
            Integer[] cur = q.poll();
            List<Integer> temp = Lists.newArrayList(cur[0], cur[1]);
            result.add(temp);

            int index1 = cur[2] + 1;
            if(index1 == arr1.length){
                continue;
            }
            //push arr1的下一个，arr2的固定一个，记录下一个arr1的指针
            q.offer(new Integer[]{arr1[index1], cur[1], index1});

        }

        return result;
    }
}
