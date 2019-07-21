package greedy;

/**
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * 算法:
 * S 集合记录了从起点到终点跳跃的地点 S ={a0, a1, a2 ... an}
 * 贪心算法中, S 包含了最少经过的点
 *
 * 第一个点是要记录到 S 中的
 * 第二个点是 max = Math.max(max, nums[i] + i); 0 < i < nums[0] + 0;
 * 第 n 个点是 max = Math.max(max, nums[i] + i); i < i < nums[i] + i;
 *
 * 注意, for loop 里 i < nums.length - 1, 减 1 的原因是 入参是 {0} 的时候会返回 1
 */
public class JumpGameII {
    public int jump(int[] nums){
        int anchor = 0;
        int max = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max = Math.max(max, nums[i] + i);
            if(anchor == i){
                steps++;
                anchor = max;
                if(anchor >= nums.length - 1){
                    return steps;
                }
            }
        }
        return 0;
    }
}
