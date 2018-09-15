object FirstUniqChar {

  @JvmStatic
  fun main(args: Array<String>) {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))

  }

  private fun firstUniqChar(s: String): Int {
    val map = HashMap<Char, Int>()
    val list = ArrayList<Int>()

    for (i in 0 until s.length) {
      if (map.containsKey(s[i]))
        map[s[i]] = Int.MAX_VALUE
      else
        map[s[i]] = i
        list.add(i)

    }

    for (i in 0 until list.size) {
      if (map[s[list[i]]] != Int.MAX_VALUE) {
        return list[i]
      }
    }

    return -1

  }
}