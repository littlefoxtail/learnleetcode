package sort

/**
 * 插入排序采用的是 in-place在数组上实现.具体算法
 * 1.从第一个元素开始,该元素可以认为已经排序
 * 2.取出下一个元素,在已经排序的元素序列中从后向前扫描
 * 3.如果该元素列表中元素大于取出的元素,将该元素移到下一位置
 * 4.重复步骤3,知道找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入最后的位置后
 * 6.重复步骤2-5
 *
 *
 * 最坏的情况,序列已经是升序排列,在这种情况下,需要进行的比较操作需(n-1)次即可.最坏的情况就是,序列是降序排列,那么此时需要比较共有
 * n(n-1)/2 ,插入排序的赋值操作是比较操作的次数减去n-1次.平均来说插入排序算法复杂度为O(n^2)
 *
 * 稳定O(n^2)
 */
object Insertion {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(8, 3, 4, 2, 9, 29, 11)
        sort(array)


    }

    fun <T : Comparable<T>> sort(a: Array<T>) {
        val N = a.size
        for (i in 0 until N) {
            var j = i
            while (j > 0 && a[j] < a[j - 1]) {
                exch(a, j, j-1)
                j--
            }
            assert(isSorted(a, 0, i))
        }
        assert(isSorted(a, 0,  N -1))


    }

    fun <T: Comparable<T>> exch(a: Array<T>, i: Int, j: Int) {
        val swap = a[i]
        a[i] = a[j]
        a[j] = swap
    }

    fun <T: Comparable<T>> isSorted(args: Array<T>, lo: Int, hi: Int): Boolean {
        for (i in lo+1..hi) {
            if (args[i] < args[i-1]) return false
        }
        return true
    }
}