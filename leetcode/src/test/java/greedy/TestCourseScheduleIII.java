package greedy;

import greedy.CourseScheduleIII;

public class TestCourseScheduleIII {
    public static void main(String[] args){
        CourseScheduleIII courseScheduleIII = new CourseScheduleIII();
        int[][] arr = {{5,15}, {3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}};
        int counter = courseScheduleIII.scheduleCourse(arr);
        System.out.println(counter);
    }
}
