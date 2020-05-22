package search;

/**
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
    public int findPeakElementRecursive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return findPeakElementRecursive(0, nums.length - 1, nums);
    }

    private int findPeakElementRecursive(int left, int right, int[] nums) {
        if(left == right){
            return left;
        }
        //因为这里取整，取较小的数，所以需要 right 往 mid 考
        int mid = (left + right)/2;
        if(nums[mid] > nums[mid + 1]) {
            return findPeakElementRecursive(left, mid, nums);
        }
        //因为mid 取整，所以 mid 要 + 1
        return findPeakElementRecursive(mid + 1, right, nums);
    }

    public int findPeakElementIterative(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid+1]) {
                //因为这里取整，而目标在左侧，所以需要 right 往 mid 靠
                right = mid;
            } else {
                ////因为mid 取整，而目标在右侧，所以 mid 要 + 1
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        FindPeakElement f = new FindPeakElement();
        int indexRecursive = f.findPeakElementRecursive(nums);
        int indexIterative = f.findPeakElementRecursive(nums);
        System.out.println("index recursive: "+ indexRecursive);
        System.out.println("index iterative: "+ indexIterative);
    }
}
