package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 630. Course Schedule III
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day.
 *
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 *
 * Example:
 *
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 * Explanation:
 * There're totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 *
 *
 * Note:
 *
 * The integer 1 <= d, t, n <= 10,000.
 * You can't take two courses simultaneously.
 *
 * 算法:
 * 不仅仅是 course 的 deadline 对结果的影响因素, 而且 course 的 duration 也对结果也有影响
 * 所以按照 course 的 dealine 从小到高排序
 * 每次选取 time + courses[i][0] <= courses[i][1] 的 course
 * 如果没选中, 查看原来选的这些课里, 是否存在 courses[j][0] > courses[i][0]; i 是当前遍历的课, j < i。
 * 如果有, 用当前 course i 替换掉之前的 course j, time += course[i][0] - course[j][0]
 *
 * Time complexity : O\big(nlog(n)\big)O(nlog(n)). At most nn elements are added to the queuequeue.
 * Adding each element is followed by heapification, which takes O(nlgn) 时间复杂度
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        if(courses == null || courses[0].length < 1){
            return -1;
        }
        Arrays.sort(courses, (a,b)->a[1] - b[1]);
        int time = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int[] course:courses){
            if(time + course[0] <= course[1]){
                time += course[0];
                queue.offer(course[0]);
            }
            else if(!queue.isEmpty() && queue.peek() > course[0]){
                int maxDuration = queue.poll();
                queue.offer(course[0]);
                time += course[0] - maxDuration;
            }
        }
        return queue.size();
    }
}
