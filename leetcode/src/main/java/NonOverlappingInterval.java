
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Example 1:
 *
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * Output: 1
 *
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 *
 * Input: [ [1,2], [2,3] ]
 *
 * Output: 0
 *
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        sortInterval(intervals);
        System.out.println(intervals);
        return getMinimumNumToRemove(intervals);
    }

    private int getMinimumNumToRemove(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int minNumToRemoveCount = 0;
        for(int i = 0, next = 1; next < intervals.length; next++){
            if(intervals[i][1] <= intervals[next][0]){
                i = next;
            }
            else{
                minNumToRemoveCount++;
            }
        }
        return minNumToRemoveCount;
    }

    private void sortInterval(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
    }
}
