//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2516 👎 0

package main.java.com.qiuyu.leetcode.leetcode.editor.cn;
public class LongestPalindromicSubstring{
  public static void main(String[] args) {
       Solution solution = new LongestPalindromicSubstring().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        //  暴力法
//        char[] charArray = s.toCharArray();
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        int maxLength = 1, begin = 0;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (j - i + 1 > maxLength && validate(charArray, i, j)) {
//                    maxLength = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLength);
        // 动态规划法
        // 状态转移方程 dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]
        if (s.length() < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int len = s.length(), maxLength = 1, begin = 0;
        boolean[][] dp = new boolean[len][len];
        // 初始化dp
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            // abcba dp[0][1] = false dp[1][1] = true;
            // dp[0][2] = false; dp[1][2] = false; dp[2][2] = true;
            // dp[0][3] = false; dp[1][3] = true; dp[2][3] = false; dp[3][3] = true;
            // dp[0][4] = true;
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    public boolean validate(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
