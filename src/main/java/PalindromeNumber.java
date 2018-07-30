/**
 * 判断一个整数是否是回文，不要使用额外的空间
 *
 * 1. 负数都不是回文数
 * 2. 不能通过将数字转为字符串来判断回文，因为使用了额外的空间
 * 3. 注意整数溢出的问题
 * 4. 这个问题有一个比较通用的解法
 *
 *
 *  形如：123456 获取回文数 654321
 *
 *  12345 6
 *  1234  5
 *  123   4
 *  12    3
 *  1     2
 *  1     1
 *
 *  可以先获取到余数  获取到一个新的值为 余数 + 余数*10
 *  每次商代表一次余数*10
 */
public class PalindromeNumber {
  public static void main(String[] args) {
    isPalindrome(123321);
  }

  public static boolean isPalindrome(int x) {
    if(x < 0) return false;
    int copyX = x, reverse = 0;
    while (copyX > 0) {
      reverse = reverse * 10 + copyX % 10;
      copyX /= 10;
    }
    return x==reverse;

  }
}
