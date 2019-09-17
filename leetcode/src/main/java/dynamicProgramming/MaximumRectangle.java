package dynamicProgramming;

import java.util.Arrays;

public class MaximumRectangle {

    /**
     *
     * height[j]: 记录当前坐标列向连续 1 的长度
     * left[j]: 记录当前坐标高度为 height[j] 连续 1 的左边界
     * right[j]: 记录当前坐标高度为 height[j] 连续 1 的右边界
     * maxArea: 最大 rectangle 面积
     * maxArea = height * (右边界 - 做边界)
     *
     * if(matrix[i][j] == '1'){
     *     height[j] ++;
     * }
     * else{
     *     height = 0;
     * }
     *
     * if(matrix[i][j] == '1'){
     *     left[j] = Math.max(left[j], cur_left) // 当前左边界满足两个条件: 在 1 上一个左边界 2 当前的左边界 中取最大的一个
     * }
     * else{
     *     left[j] = 0;    //遇到 0, 当然清空了
     *     cur_left = j+1; //遇到 0, 左边界至少是 j + 1
     * }
     *
     * if(matrix[i][j] == '1'){
     *     right[j] = Math.min(right[j], cur_right); // 当前的右边界满足两个条件: 在 1 上一个右边界 2 当前右边界 中取最小的一个
     * }
     * else{
     *     right[j] = n - 1;
     *     cur_right = j - 1;
     * }
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n -1);
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            //获取连续增高的高度
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }
            //获取高度为 height[j] 的左边界
            int curLeft = 0;
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(curLeft, left[j]); //  左边界取短板, 括号里的 left[j] 是上一行高度为height[j]的最左边界, curLeft 是这一行的最左边界
                }
                else{
                    left[j] = 0; // 如果matrix[i][j] = 0, 左边界为0 因为都满足高度为 0
                    curLeft = j+1; //遇到 0, 左边界至少是 j + 1, 用来记录这一行的最左边界
                }
            }
            //获取高度为 height[j] 的右边界
            int curRight = n -1;
            for(int j = n -1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(curRight, right[j]);  //右边界取短板, 括号里的 right[j] 是上一行的最右边界
                }
                else{
                    right[j] = n - 1; // 如果matrix[i][j] = 0, 右边界为 n - 1, 因为都满足高度为 0
                    curRight = j - 1; //遇到 0, 右边界至少是 j - 1,用来记录当前行的最右边界
                }
            }
            //获取最大面积
            for(int j = 0; j < n; j++){
                maxArea = Math.max(maxArea, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return maxArea;
    }

    public int maximalRectangleExcample(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int[] height = new int[n];
        int maxArea = 0;
        for( int i = 0; i < m; i++ ){
            int left_boundary = 0;
            int right_boundary = n;
            for( int j = 0; j < n; j++ ){ //left boundary
                if( matrix[i][j] == '1' ){
                    left[j] = Math.max( left[j], left_boundary );
                }
                else{
                    left[j] = 0;
                    left_boundary = j + 1;
                }
            }
            for( int j = n - 1; j >=0; j-- ){  //right boundary
                if( matrix[i][j] == '1' ){
                    right[j] = Math.min( right[j], right_boundary );
                }
                else{
                    right[j] = n;
                    right_boundary = j;     //in order to get length
                }
            }
            for( int j = 0; j < n; j++ ){   //height
                if( matrix[i][j] == '1' ){
                    height[j]++;
                }
                else{
                    height[j] = 0;
                }
            }
            for( int j = 0; j < n; j++ ){
                maxArea = Math.max( maxArea, (right[j] - left[j])*height[j] );
            }
        }
        return maxArea;
    }
}
