package greedy;

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
     * input = S
     * S{a1,a2,a3, ... ai ... an)
     * 那么 ai 只要满足 S 中第一个唯一值之前的的最小的 letter
     * 接下来需要在 ai+1 ~ an 中找到下一个 唯一值之前的的最小的 letter
     * 这些结果组合起来就是 S 中唯一值前的最小值和唯一值们组成的集合, 最小值会
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] arr = new int[26];
        for(int i =0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < s.charAt(pos)){
                pos = i;
            }
            if(--arr[s.charAt(i) - 'a'] == 0){
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replace("" + s.charAt(pos), ""));
    }


}
