import greedy.MaxActivity;

import java.util.List;

public class TestMaxActivity {
    public static void main(String[] args){
        int[] leftEdge = {1,3,0,5,3,5,6,8,8,2,12};
        int[] rightEdge = {4,5,6,7,9,9,10,11,12,14,16};
        MaxActivity maxActivity = new MaxActivity();
        List<Integer> result = maxActivity.getMaxActivities(leftEdge, rightEdge);
        System.out.println(result);
    }
}
