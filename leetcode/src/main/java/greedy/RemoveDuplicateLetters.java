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

    public String removeDuplicateLetters2(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder result = new StringBuilder();
        int[] cnt = new int[26];
        for(int i =0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
        }
        while(s.length() != 0){
            int pos = 0;
            for(int i = 0; i < s.length(); i++){
                //记录唯一字符出现前的最下字母位置
                if(s.charAt(i) < s.charAt(pos)){
                    pos = i;
                }
                //找出唯一字符的则停
                if(--cnt[s.charAt(i) - 'a'] == 0){
                    break;
                }
            }
            result.append(s.charAt(pos));
            cnt[pos] = 0;
            s = s.substring(pos+1).replace("" + s.charAt(pos), "");
        }
        return result.toString();
    }
    public String removeDuplicateLetters3(String sr) {

        int[] count = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = sr.toCharArray();
        for(char c: ch){  //count number of occurences of character
            count[c-'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;
        for(char s:ch){
            index= s-'a';
            count[index]--;   //decrement number of characters remaining in the string to be analysed
            if(visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while(!st.isEmpty() && s<st.peek() && count[st.peek()-'a']!=0){
                visited[st.pop()-'a']=false;
            }
            st.push(s); //add current character and mark it as visited
            visited[index]=true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }

    public String removeDuplicateLetters4(String s){
        char[] count = new char[26];
        for(char e:s.toCharArray()){
            count[e-1]++;
        }

    }
}
