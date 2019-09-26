package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 140. Word Break II
 * Hard
 *
 * 1192
 *
 * 273
 *
 * Favorite
 *
 * Share
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        return wordBreak(s, wordDict, 0, map);
    }

    /**
     * 返回 从 indexS 到 end 所组合的成 List<String>
     * @param s
     * @param wordDic
     * @param indexS
     * @param map 存储了从 indexS 到 end 组合成 List<String> 的结果
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDic, int indexS, Map<Integer, List<String>> map){
        if(indexS == s.length()){
            return null;
        }
        if(map.get(indexS) != null){
            return map.get(indexS);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < wordDic.size(); i++){
            String word = wordDic.get(i);
            if(indexS + word.length() < s.length() + 1 && word.equals(s.substring(indexS, indexS + word.length()))){
                List<String> breakableWordList = wordBreak(s, wordDic, indexS + word.length(), map);
                if(breakableWordList == null){
                    result.add(word);
                    continue;
                }
                for(String breakableWord:breakableWordList){
                    result.add(word + " " + breakableWord);
                }
            }
        }
        map.put(indexS, result);
        return result;
    }

}
