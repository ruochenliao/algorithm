import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int globalMax = 0;
        int anchor = 0;
        for(int i = 0; i < s.length(); i++){
            if(null != map.get(s.charAt(i))){
                anchor = Math.max(anchor, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            globalMax = Math.max(i - anchor + 1, globalMax);
        }
        return globalMax;
    }
}
