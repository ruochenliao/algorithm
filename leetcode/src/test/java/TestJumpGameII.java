import greedy.JumpGameII;

public class TestJumpGameII {
    public static void main(String[] args){
        JumpGameII game = new JumpGameII();
        int[] arr = {2,3,1,1,4};
        int[] arr1 = {0};
        int steps = game.jump(arr);
        game.jump(arr1);
        System.out.println(steps);
    }
}
