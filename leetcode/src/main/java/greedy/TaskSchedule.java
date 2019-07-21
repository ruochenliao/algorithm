package greedy;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling intervaln that means between twosame tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example 1:
 *
 * Input: tasks = ['A','A','A','B','B','B'], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * Note:
 *
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 题意
 * 关键：模拟CPU任务分配，A 到 Z表示不同的任务，任务可以以不同顺序进行。每个任务可以在一个时间间隔中完成。对于一个时间间隔，CPU可以执行一个任务或者是闲置。但是，两个同样的任务之间需要有 n 个冷却时间，也就是说假如A执行后，那么未来n个时间间隔内，A是不允许再执行的。
 *
 * 说明：
 *
 * 该问题可以看做区间找点问题的扩展，只不过可让区间进行扩展。
 *
 * 思路
 * If we are able to, somehow, determine the number of idle slots(idle\_slotsidle_slots), we can find out the time required to execute all the tasks as idle\_slots + Total Number Of Tasksidle_slots+TotalNumberOfTasks. Thus, the idea is to find out the idle time first.
 * eg 一个 tasks = { 4 个 A, 4 个 B, 3 个 C, 1 个 D} n = 5
 * [
 *  A, B, C, D, x
 *  A, B, C, x, x
 *  A, B, C, x, x
 *  A, B
 * ]
 * x 代表了 idle; 4 个 A, 计算出 那么总共有 5 个 Interval
 * 5 个 interval + task.length = 17
 *
 * 算法:
 * 排序分类, 数量最多的就是那一组决定有多少 interval
 * idle 时间 = (4 - 1) * n = 3 * 5 = 15
 * 循环比遍历减去任务 occupy 的, 剩下的就是应该 idle 的时间
 *
 */
public class TaskSchedule {
    public int leastInterval(char[] tasks, int n) {
        Integer[] map = new Integer[26];
        Arrays.fill(map, 0);
        for(char t:tasks){
            map[t - 'A']++;
        }
        Arrays.sort(map, (o1, o2)-> o2 - o1);
        int idleSlots = (map[0] - 1) * n;
        for(int i = 1; i < 26 && map[i] != 0; i++){
            idleSlots -= Math.min(map[0] -1, map[i]);
        }
        return idleSlots > 0? idleSlots + tasks.length: tasks.length;
    }
}
