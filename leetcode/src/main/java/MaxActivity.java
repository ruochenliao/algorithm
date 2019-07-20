import java.util.LinkedList;
import java.util.List;

public class MaxActivity {
    /**
     * 用两个数组表示一组活动时间, 要求 rightEdge 已按时间从低到高排好序了
     * @param leftEdge
     * @param rightEdge
     * @return
     */
    public List<Integer> getMaxActivities(int[] leftEdge, int[] rightEdge){
        if(leftEdge == null || rightEdge == null || leftEdge.length != rightEdge.length){
            return null;
        }
        List<Integer> result = new LinkedList<>();
        result.add(0);
        for(int cur = 0, next = 1; next < leftEdge.length; next++){
            if(rightEdge[cur] < leftEdge[next]){
                result.add(next);
                cur = next;
            }
        }
        return result;
    }
}
