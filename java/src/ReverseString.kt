object ReverseString {
  @JvmStatic
  fun main(args: Array<String>) {
    println(reverseString("423"))

    println(reverseString2("1221"))
  }

  private fun reverseString(s: String): String {
    val byteArray = s.toCharArray()
    var result = ""
    for (i in byteArray.size-1 downTo 0) {
      result += byteArray[i]

    }
    return result
  }

  private fun reverseString2(s: String): String {
    val ch = s.toCharArray()
    var temp: Char
    val half = s.length / 2
    for (i in 0 until  half) {
      temp = ch[s.length -1 - i ]
      ch[i] = ch[s.length - 1 - i]
      ch[s.length - i -1] = temp

    }
    return String(ch)
  }


}
