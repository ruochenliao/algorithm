package dynamicProgramming;

public class TestMonkHanoiTowerByStacks {
    public static void main(String[] args){
        MonkHanoiTowerByStacks stacks = new MonkHanoiTowerByStacks();
        int n = 5;
        int result = stacks.minMoveByHanoi(n);
        System.out.println(result);
    }
}
