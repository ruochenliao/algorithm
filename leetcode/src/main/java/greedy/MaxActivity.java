package greedy;

import java.util.LinkedList;
import java.util.List;

/**
 * 设有n个活动的集合E＝{1，2，…，n}，其中每个活动都要求使用同一资源，如演讲会场等，而在同一时间内只有一个活动能使用这一资源。
 * 每个活动i都有一个要求使用该资源的起始时间si和一个结束时间fi，且si＜fi。如果选择了活动i，则它在半开时间区间[si ，fi )内占用资源。若区间[si ，fi )与区间[sj，fj )不相交，则称活动i与活动j是相容的。当 si ≥ fj 或 sj ≥ fi 时，活动i与活动j相容。
 * 活动安排问题就是在所给的活动集合中选出最大的相容活动子集合。
 *
 * 作者：追云的帆
 * 链接：https://www.jianshu.com/p/5a97bcc407fa
 * 来源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
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
