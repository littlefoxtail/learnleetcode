
import java.util.ArrayList
import java.util.Collections.addAll
import java.util.LinkedList
import java.util.Arrays
import java.util.HashSet

fun openLock(deadends: Array<String>, target: String?): Int {
    val pos = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    val set = HashSet(Arrays.asList(*deadends))
    val list = LinkedList<String>()
    if (target == null || target.length == 0 || set.contains("00000")) {
        return -1
    }
    list.add("0000")
    var depth = 0
    while (!list.isEmpty()) {
        var size = list.size
        while (size-- > 0) {
            val str = list.removeFirst()
            if (str == target) {
                return depth
            }
            if (!set.contains(str)) {
                set.add(str)
                list.addAll(getNextList(str, pos))
            }
        }
        depth++
    }
    return -1
}

private fun getNextList(str: String, pos: CharArray): List<String> {
    val res = ArrayList<String>()
    val chars = str.toCharArray()
    for (i in chars.indices) {
        val num = chars[i] - '0'
        val newChars = chars.clone()
        newChars[i] = pos[(num + 11) % 10]//数字+1
        res.add(String(newChars))
        newChars[i] = pos[(num + 9) % 10] //数字-1
        res.add(String(newChars))
    }
    return res
}

fun main() {
    val array1 = arrayOf("0201","0101","0102","1212","2002")
    val target = "0202"
    print(openLock(array1, target))
}