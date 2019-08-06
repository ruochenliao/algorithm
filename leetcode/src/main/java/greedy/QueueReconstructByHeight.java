package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater
 * than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 思路: 同样高的情况下, k 值越小越应该在前面;
 *      如果矮子插入队列中, 对高个不会有影响;
 *
 * 贪心策略: 先插入高的, 如果高度相同,则先插入 k 值交小的;
 *
 *
 *
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
