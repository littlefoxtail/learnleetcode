/**
 *  return the index of the first occurrence of needle in haystack,
 *  or -1 if needle is not part of haystack
 *
 *  Example 1:
 *  Input: haystack = "hello", needle = "ll"
 *  Output: 2
 *
 *
 *  Input: haystack = "aaaaa", needle = "bba"
 *  Output: -1
 *
 *  题意
 *  是从主串中找到子串的索引，如果找不到则返回-1，当字符串长度大于主串，直接返回-1
 */

public class StrStr {

  public static void main(String[] args) {
   String haystack = "hello", needle = "l0";
   strStr(haystack, needle);
  }

  public static int strStr(String haystack, String needle) {
    int l1= haystack.length(), l2 = needle.length();
    if (l1 < l2) return -1;
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        System.out.println("i=>" + i + " j=" + j);
        if (j == l2) return i;
        if (i +j == l1) return -1;
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;

        }

      }

    }
  }
}
