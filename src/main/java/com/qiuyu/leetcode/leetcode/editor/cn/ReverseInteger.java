//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2087 👎 0

package main.java.com.qiuyu.leetcode.leetcode.editor.cn;
public class ReverseInteger{
  public static void main(String[] args) {
       Solution solution = new ReverseInteger().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        double check = 0;
        int checkX = x;
        boolean sign = false;
        // 符号处理
        if (x < 0) {
            sign = true;
            x = Math.abs(x);
            checkX = Math.abs(checkX);
        }
        // 校验溢出
        while (checkX > 0) {
            check = 10 * check + checkX % 10;
            checkX = checkX / 10;
        }
        if (check > Integer.MAX_VALUE) {
           return res;
        }
        // 翻转数字
        while (x > 0) {
            int y = x % 10;
            x /= 10;
            res = res * 10 + y;
        }
        if (sign) {
            return -res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
