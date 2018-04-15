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
object ReverseInteger {
  @JvmStatic
  fun main(args: Array<String>) {
    println(reverse(123))
  }

  private fun reverse(x: Int): Int {
    var x = x
    var res = 0

    while (x != 0) {
      res = res * 10 + x % 10
      x /= 10
    }

    return if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) 0 else res
  }
}
