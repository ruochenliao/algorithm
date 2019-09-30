package dynamicProgramming;

/**
 * 174. Dungeon Game
 * Hard
 *
 * 827
 *
 * 19
 *
 * Favorite
 *
 * Share
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * {
 *     {-2, -3, 3},
 *     {-5, -10, 1},
 *     {10, 30, -5}
 * }
 */
public class DungeonGame {
    /**
     * recursive dp
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHpRecursive(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return -1;
        }
        Integer[][] hp = new Integer[dungeon.length][dungeon[0].length];
        return calculateMinimumHPRecursive(dungeon, 0, 0, hp);
    }

    /**
     * calculateMinimumHPRecursive(dungeon, int i, int j): 返回值表示到达点(i,j) 至少需要的 hp
     * @param dungeon dungeon[i][j]: 存储到达点(i, j) 最少需要的 hp
     * @param i
     * @param j
     * @return
     */
    public int calculateMinimumHPRecursive(int[][] dungeon, int i, int j, Integer[][] hp){
        if(i == dungeon.length && j == dungeon[0].length - 1){
            return 1;
        }
        if(i == dungeon.length - 1 && j == dungeon[0].length){
            return 1;
        }
        if(i >= dungeon.length || j >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(hp[i][j] != null){
            return hp[i][j];
        }
        int downHp = calculateMinimumHPRecursive(dungeon, i+1, j, hp);
        int rightHp = calculateMinimumHPRecursive(dungeon, i, j+1, hp);
        int curHp = Math.min(downHp, rightHp) - dungeon[i][j];
        hp[i][j] = curHp <= 0? 1:curHp;
        return hp[i][j];
    }

    /**
     * iterative dp
     * @param dungeon dungeon[i][j]: 到达点(i, j) 至少需要的 hp
     * @return
     */
    public int calculateMinimumHpIterative(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHp = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            minHp[i][n] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n; i++){
            minHp[m][i] = Integer.MAX_VALUE;
        }
        minHp[m-1][n] = 1;
        minHp[m][n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int curHp = Math.min(minHp[i+1][j], minHp[i][j+1]) - dungeon[i][j];
                minHp[i][j] = curHp <= 0 ? 1:curHp;
            }
        }
        return minHp[0][0];
    }
}
