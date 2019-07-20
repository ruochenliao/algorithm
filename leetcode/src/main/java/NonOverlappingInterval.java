
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        sortInterval(intervals);
        System.out.println(intervals);
        return getMinimumNumToRemove(intervals);
    }

    private int getMinimumNumToRemove(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int minNumToRemoveCount = 0;
        for(int i = 0, next = 1; next < intervals.length; next++){
            if(intervals[i][1] <= intervals[next][0]){
                i = next;
            }
            else{
                minNumToRemoveCount++;
            }
        }
        return minNumToRemoveCount;
    }

    private void sortInterval(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
    }
}
