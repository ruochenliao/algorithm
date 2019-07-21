package greedy;

public class JumpGameI {
    public boolean canJump(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length && i <= max; i++){
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
