/**
 * 写一个函数来寻找一个字符串数组中最长公共前缀。
 * "abcdefg"
 * "abcdefghijk"
 * "abcdfghijk"
 * "abcef"
 * 
 * 上面字符串数组的最长公共前缀就是"abc"
 * 
 * 找出最短的那个字符串
 * 然后从index=0开始查找，如果找到有相同位的字符不相等的，就截取0~当前位置(因为取头部取尾)
 * 
 * 如果循环完成都没有找到，这说明最短那个字符串就是最长前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"abcdefg","abcdefghijk","abcdfghijk","abcef"});
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        for (String st: strs) {
            minLen = Math.min(minLen, str.length);
        }
        for (int j = 0; j < minLen; j++) {
            for (int i = 0; i < len; i ++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}

