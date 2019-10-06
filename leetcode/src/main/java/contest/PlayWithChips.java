package contest;

/**
 * 5213. Play with Chips
 * User Accepted: 941
 * User Tried: 1125
 * Total Accepted: 942
 * Total Submissions: 1258
 * Difficulty: Easy
 * There are some chips, and the i-th chip is at position chips[i].
 *
 * You can perform any of the two following types of moves any number of times (possibly zero) on any chip:
 *
 * Move the i-th chip by 2 units to the left or to the right with a cost of 0.
 * Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
 * There can be two or more chips at the same position initially.
 *
 * Return the minimum cost needed to move all the chips to the same position (any position).
 *
 *
 *
 * Example 1:
 *
 * Input: chips = [1,2,3]
 * Output: 1
 * Explanation: Second chip will be moved to positon 3 with cost 1. First chip will be moved to position 3 with cost 0. Total cost is 1.
 * Example 2:
 *
 * Input: chips = [2,2,2,3,3]
 * Output: 2
 * Explanation: Both fourth and fifth chip will be moved to position two with cost 1. Total minimum cost will be 2.
 * Constraints:
 *
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 */
public class PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        if(chips == null || chips.length == 0){
            return 0;
        }
        int maxCount = Integer.MAX_VALUE;
        for(int i = 0; i < chips.length; i++){
            int counter = 0;
            for(int j = 0; j < chips.length; j++){
                if(Math.abs(chips[j]-chips[i])%2 == 1){
                    counter++;
                }
            }
            maxCount = Math.min(maxCount, counter);
        }
        return maxCount;
    }
}
