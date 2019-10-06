package contest;

public class TestPlayWithChips {
    public static void main(String[] args){
        PlayWithChips chips = new PlayWithChips();
        int[] arr = {2,2,2,3,3};
        int result = chips.minCostToMoveChips(arr);
        System.out.println(result);
    }
}
