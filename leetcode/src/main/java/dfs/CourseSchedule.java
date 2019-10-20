package dfs;

import java.util.*;

/**
 * 207. Course Schedule
 * Medium
 *
 * 2316
 *
 * 112
 *
 * Favorite
 *
 * Share
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 0){
            return false;
        }
        if((prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)){
            return true;
        }
        Map<Integer, Set<Integer>> requirementMap = new HashMap<>();
        Map<Integer, Boolean> ableFinishMap = new HashMap<>();
        for(int[] pair:prerequisites){
            if(!requirementMap.containsKey(pair[0])){
                requirementMap.put(pair[0], new HashSet<>());
            }
            Set<Integer> set = requirementMap.get(pair[0]);
            set.add(pair[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!canFinish(i, requirementMap, ableFinishMap, numCourses)){
                return false;
            }
        }
        return true;
    }

    private boolean canFinish(int curCouse, Map<Integer, Set<Integer>> requirementMap, Map<Integer, Boolean> ableFinishMap, int numCourses) {
        if(curCouse >= numCourses){
            return false;
        }
        if(ableFinishMap.containsKey(curCouse)){
            return ableFinishMap.get(curCouse);
        }
        boolean ableToFinish = true;
        if(requirementMap.containsKey(curCouse)){
            ableFinishMap.put(curCouse, false);
            Set<Integer> requiredCourseSet = requirementMap.get(curCouse);
            for(Integer requiredCourse:requiredCourseSet){
                if(!canFinish(requiredCourse, requirementMap, ableFinishMap, numCourses)){
                    ableToFinish = false;
                    break;
                }
            }
        }
        ableFinishMap.put(curCouse, ableToFinish);
        return ableToFinish;
    }
}
