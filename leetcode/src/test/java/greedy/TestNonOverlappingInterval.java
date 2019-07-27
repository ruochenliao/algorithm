package greedy;

import greedy.NonOverlappingInterval;

public class TestNonOverlappingInterval {
    public static void main(String[] args){
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        NonOverlappingInterval nonOverlappingInterval = new NonOverlappingInterval();
        int result = nonOverlappingInterval.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }
}
