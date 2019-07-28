package dynamicProgramming;

/**
 * 求两个 string 最长公共 string 以及他们的长度
 *
 * X 和 Y 的公共序列是 Z
 * 定义 X = {x1, x2, x3 ... xj ... xm }
 *     Y = {y1, y2, y3 ... yj ... yn }
 *     长度是 c[i, j]
 * 定义 c[i, j] 为 Xi 和 Yj 的最长公共序列的长度
 *
 * c[i, j] = {
 *     0,                               (i = 0, j = 0)
 *     c[i-1, j- 1] + 1                 (xi = yj)
 *     Math.max(c[i-1, j], c[i, j -1])  (xi != yj)
 * }
 */
public class LongestCommonString {
    public String getLongestCommonStr(String s1, String s2){
        int[][] c = new int[s1.length()+1][s2.length()+1];
        String[][] b = new String[s1.length()+1][s2.length()+1];
        for(int i = 1; i < s1.length() + 1; i++){
            for(int j =1; j < s2.length() + 1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    c[i][j] += c[i-1][j-1] + 1;
                    b[i][j] = "^<";
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = "^";
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = "<";
                }
            }
        }
        System.out.println("最长长度是 "+ c[s1.length()][s2.length()]);
        return getStr(b, s1);
    }

    private String getStr(String[][] b, String s1) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = b.length - 1, j = b[0].length -1;
        while(i >0 && j > 0){
            if(b[i][j].equals("^<")){
                stringBuilder.append(s1.charAt(i-1));
                i--; j--;
            }
            else if((b[i][j].equals("^"))){
                i--;
            }
            else{
                j--;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
