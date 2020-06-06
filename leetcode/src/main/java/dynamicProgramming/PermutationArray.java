package dynamicProgramming;

import java.util.*;

/**
 * 给出一个数组，给出所有种组合
 */
public class PermutationArray {
    /**
     * 在 nums[] 中, 每层 help 以 start 为开头的排列组合
     * @param nums
     * @param prefix
     * @param hs
     * @param result
     */
    private void help(Integer[] nums, int start, String prefix, HashSet<String> hs, List<String> result){
		if(prefix.length() != 0 && !hs.contains(prefix)){
			result.add(prefix);
			hs.add(prefix);
		}

		for(int i = start; i < nums.length; i++){
			help(nums, i + 1,prefix + nums[i], hs, result);
		}
	}

	public List<String> permutation(Integer[] nums){
        List<String> result = new ArrayList<>();
        help(nums, 0, "", new HashSet<>(), result);
        return result;
    }

	public static void main(String[] args) {
		Integer[] nums = {1,2,3};
		PermutationArray permutationArray = new PermutationArray();
		List<String> result = permutationArray.permutation(nums);
		for(String i:result){
            System.out.println(i);
        }
	}
}
