package sort

import edu.princeton.cs.introcs.StdRandom

object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(5, 7, 88, 2, 22, 3, 4, 10)
        quickSort(array, 0, array.size - 1)

        StdRandom.shuffle(array)

        println()

        for (i in 0 until array.size) {
            val ith = select(array, i)
            println(ith)

        }

    }

    private fun <T: Comparable<T>> quickSort(a: Array<T>, lo: Int, hi: Int) {
        if (hi <= lo) return
        val j = partition(a, lo, hi)
        quickSort(a, lo, j-1)
        quickSort(a, j+1, hi)
        assert(isSorted(a, lo, hi))
    }

    /**
     * 终极目标还是要分治lo，它的左侧必须小，右侧必须大
     * 左侧肯定比右侧小
     *
     * 找到左侧比分治值大的 右侧壁分治值小的，两个交换
     * 当
     *
     */
    private fun <T: Comparable<T> > partition(a: Array<T>, lo: Int, hi: Int): Int {
        var i = lo //头部
        var j = hi + 1 //屁部
        val v = a[lo] //基准

        while (true) {
//            找到item
            while (a[++i] < v) {
                //如果基准比头部大 ++
//                如果比基准小，需要交换两个的位置
                if (i == hi)
                    break
            }

            while (v < a[--j]) {
//                如果基准比尾部小 就--
//                否则就交换位置
                if (j == lo) {
                    break
                }
            }
            if (i >= j) {
                break
            }
            exch(a, i, j)

        }
//        这里都过了头，但是j过头的话，就是比lo小的值了，i过头的话就是比l0大的值，所以这里需要与j交换位置
        exch(a, lo, j)
        return j

    }


    fun <T: Comparable<T>> exch (a: Array<T>, i: Int, j: Int) {
        val swap = a[i]
        a[i] = a[j]
        a[j] = swap
    }

    private fun <T: Comparable<T>> show(a: Array<T>) {
        for (i: Int in a.indices) {
            println(a[i])
        }
    }

    private fun <T: Comparable<T>> isSorted(a: Array<T>, lo: Int, hi: Int): Boolean {
        for (i in lo + 1..hi) {
            if (a[i]< a[i-1]) {
                return false
            }
        }
        return true
    }

    /**
     * 选择排序
     * @param a 对应数组
     * @param k 找出第kth小的
     */
    fun <T: Comparable<T>> select(a: Array<T>, k: Int): T {
        if (k !in 0 until a.size) {
            throw IndexOutOfBoundsException("Selected element out of bounds")
        }
        var lo = 0
        var hi = a.size - 1
        while (hi > lo) {
//            分治i的
            val i = partition(a, lo, hi)
            when {
//                和分治的i比较比k大的肯定在右侧
                i > k -> hi = i - 1
//                比k小的肯定在左侧
                i < k -> lo = i + 1
//                相同就返回
                else -> return a[i]
            }

        }
        return a[lo]
    }
}