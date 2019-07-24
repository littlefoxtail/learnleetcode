import java.util.HashMap;

/**
 * 罗马数字转整形数
 *
 * 范围是1到3999
 *
 */
public class RomanToInteger {

  public static void main(String[] args) {
    System.out.println(romanToInt("IV"));
  }

  public static int romanToInt(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int len = s.length();
    int sum = map.get(s.charAt(len - 1));
    for (int i = len - 2; i >= 0; --i) {
      if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
        sum -= map.get(s.charAt(i));
      } else {
        sum += map.get(s.charAt(i));
      }
    }
    return sum;
  }
}