package data.structure;

/**
 * 题目：
 * 有很多个用户 id：每个id后面都有进入到这个网页的时间和离开这个网页的时间。
 * 也就是我有这样的输入：
 * user_id1 , enter_time1, leave_time1
 * user_id2 , enter_time2, leave_time2
 * user_id3 , enter_time3, leave_time3
 * 解法：
 * 把一天的时间铺平成一个数组，每个时间点记录进来次数和离开次数，累加进入数和离开数就是当前时间点上的在线人数
 */
public class CountOnlineNum {
    /**
     * @param login 登录的时间点, value 值表示登录的时间点
     * @param leave 离开的时间点, value 值表示离开的时间点
     * @param k     总时间计数
     */
    void countOnlineNum(int[] login, int[] leave, int k) {
        int[] result = new int[k + 1];
        int[] tLogin = new int[k + 1];
        int[] tLeave = new int[k + 1];
        //记录每个时间点登录次数
        for (int i = 0; i < login.length; i++) {
            tLogin[login[i]] += 1;
        }
        //记录每个时间点离开次数
        for (int i = 0; i < leave.length; i++) {
            tLeave[leave[i]] += 1;
        }
        //累加，累减，统计每个时间点上的在线人数
        for (int i = 0; i < k + 1; i++) {
            result[i] = +tLogin[i];
            result[i] -= tLeave[i];
        }
        for(int value:result){
            //打印出每个时间点上的在线人数
            System.out.println(value);
        }
    }
}
