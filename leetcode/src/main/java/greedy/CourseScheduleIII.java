package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        if(courses == null || courses[0].length < 1){
            return -1;
        }
        Arrays.sort(courses, Comparator.comparingInt(x -> x[0]));
        int counter = 0;
        counter++;
        int next = 1;
        int anchor = courses[0][0];
        for(int i = 0; i < courses.length && next < courses.length; next++){
            if(anchor <= courses[next][1] - courses[next][0]){
                anchor += courses[next][0];
                counter++;
                i = next;

            }
        }
        return counter;
    }
}
