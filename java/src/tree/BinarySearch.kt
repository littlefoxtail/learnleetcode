package tree

/**
 * 二分查找，在有序数组中查找某一特定元素的搜索算法。搜索过程从中间元素开始
 */
object BinarySearch {
    @JvmStatic
    fun main(args: Array<String>) {
//        val input = Scanner(System.`in`)

        val array = Array<Int>(10) {0}

        val key = 5
        for (i in 0..9) {
            array[i] = i + 1
        }

        val index = BS(array, key, 0, 10)

        if (index != -1)
            println("Number $key found at index number : $index")
        else
            println("Not found")


    }

    fun <T : Comparable<T>> BS(array: Array<T>, key: T, lb: Int, rb: Int): Int {
        if (lb > rb) {
            return -1
        }

        val mid = (lb + rb).ushr(1)

        val comp = key.compareTo(array[mid])

        if (comp < 0) {
            return BS(array, key, lb, mid - 1)
        }

        return if (comp > 0) {
            BS(array, key, mid + 1, rb)
        } else mid
    }
}
