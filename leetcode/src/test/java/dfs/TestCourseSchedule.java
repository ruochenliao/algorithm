package dfs;

public class TestCourseSchedule {
    public static void main(String[] args){
        CourseSchedule schedule = new CourseSchedule();
        int[][] arr = {
                {1,0},
                {1,2},
                {0,1}
        };
        boolean ableFinish = schedule.canFinish(3, arr);
        System.out.println(ableFinish);
    }
}
