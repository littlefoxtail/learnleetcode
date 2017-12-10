/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Input:123
 * Output:321
 *
 * Input -123
 * Output: -321
 *
 * Input:120
 * Output:21
 *
 * 题意
 * 给一个整型数，求它的逆序整形数，注意，当它的逆序整形溢出的话，那么就返回0，
 */
public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(123));
  }

  public static int reverse(int x) {
    long res = 0;

    for (; x != 0; x /= 10) {
      res = res * 10 + x % 10;
    }

    return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
  }
}
