object IsAnagram {

  @JvmStatic
  fun main(args: Array<String>) {
    println(isAnagram1("anagram", "nagaram"))
    println(isAnagram1("aacc", "ccas"))
  }

  private fun isAnagram1(s: String, t: String): Boolean {
    if (s.length != t.length) {
      return false
    }

    val t1 = StringBuilder(t)
    for (i in 0 until s.length) {
      var found = false
      for (j in 0 until t1.length) {
        if (s[i] == t1[j]) {
          t1[j] = '0'
          found = true
          break
        } else{
          found = false
        }
      }

      if (!found) {
        return false
      }


    }
    return true

  }

//  private fun isAnagram2(s: String, t: String): Boolean {
//    if (s.length != t.length) {
//      return false
//    }
//    val array1 = arrayOfNulls<Char>(s.length)
//
//    for(i in s.indices) {
//      array1[i] = s[i]
//    }
//    val array2 = arrayOfNulls<Char>(t.length)
//
//    for(i in t.indices) {
//      array2[i] = s[i]
//    }
//
//
//    QuickSort.QS(array1, 0, s.length -1)
//    QuickSort.QS(array2, 0, t.length -1)
//
//    return s == t
//
//  }
}