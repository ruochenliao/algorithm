package greedy;

import java.util.Stack;

public class RemoveDuplicateLetters {
    /**
     * 简单地移除重复的字母, 并能保证原有的字母顺序
     * @param s
     * @return
     */
    public String removeDuplicateLetter(String s){
        int[] arr = new int[26];
        StringBuilder strB = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)]++;
            if(arr[s.charAt(i)] == 1){
                strB.append(s.charAt(i));
            }
        }
        return strB.toString();
    }

    /**
     * 不仅仅要去重, 而且要在这些去重的结果中， 找到最符合字母表顺序的那个
     * 如果结果集是 result
     * 那么唯一值的顺序是不能变的. 只要在唯一值之前比唯一值小 letter 就应该在 result 结果集里
     *
     * input = S
     * S{a1,a2,a3, ... ai ... an)
     * if(a3 是唯一的 && a1 < a2 < a3)
     *      result += {a1}
     * 接下来需要在 ai+1 ~ an 中找到下一个 唯一值之前的的最小的 letter
     * 这些结果组合起来就是 S 中唯一值前的最小值和唯一值们组成的集合, 最小值会
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        char[] count = new char[26];
        boolean[] recorded = new boolean[26];
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            count[c - 'a']++;
        }
        for (char c : arr) {
            int index = c - 'a';
            count[index]--;
            if (recorded[index]) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek()-'a'] != 0) {
                recorded[stack.pop() - 'a'] = false;
            }
            recorded[index] = true;
            stack.push(c);
        }
        StringBuilder strBild = new StringBuilder();
        while (!stack.isEmpty()) {
            strBild.insert(0, stack.pop());
        }
        return strBild.toString();
    }
}
