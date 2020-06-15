package sort;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class MinValueOfCombinationInArray {
    public Long minValueOfCombination(String[] nums){
        Arrays.sort(nums, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(nums).forEach(stringBuilder::append);
        return Long.valueOf(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"321", "32", "3"};
        MinValueOfCombinationInArray combinationInArray = new MinValueOfCombinationInArray();
        long result = combinationInArray.minValueOfCombination(strs);
        System.out.println(result);


        List<String> input = Lists.newArrayList("A","C","E","B","F","D");
        List<String> originOrder = combinationInArray.getOriginOrder(input);
        originOrder.stream().forEach(System.out::print);
    }

    public List<String> getOriginOrder(List<String> list) {
        int len = list.size();
        List<String> res = Lists.newArrayListWithCapacity(len);
        for (int i = len - 1; i >= 0; i--) {
            end2start(res);
            res.add(0,list.get(i));
        }
        return res;
    }

    private void end2start(List<String> res) {
        if(res == null || res.size() <= 0){
            return;
        }
        String temp = res.get(res.size()-1);
        res.remove(temp);
        res.add(0,temp);
    }

}
