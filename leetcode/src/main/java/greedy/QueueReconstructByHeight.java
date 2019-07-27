package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 思路: 如果 k 值越低的人越应该站到前面, 但是如果后面的人比前面的人高, 后面的 k 值可以比前面的低
 *
 * 如果能把人按高度从高往低排序, 并且高度相同的按 k 值从低往高排序,
 * 那么遍历这个排好序的数组, h 越高且k 值越低的, 越先被遍历到;
 * 如果把 k 值相同的 h 低的数组插入到 h 高的数组前, 那么 k 值相同的就会从低往高排序
 */
public class QueueReconstructByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> list = new LinkedList<>();
        for(int[] p:people){
            list.add(p[1], p);
        }
        return list.toArray(new int[0][0]);
    }
}
