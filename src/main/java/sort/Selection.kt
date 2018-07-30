package sort

import edu.princeton.cs.introcs.StdOut



/**
 * 选择排序是一种简单直观的排序算法。它的工作原理是每一次从待排序的数据元素中
 * 选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完
 *
 * 不稳定，时间复杂度 O(n^2)
 */
object Selection {

    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(3, 2, 1, 4, 10, 5, 9)
        sort(array)
        show(array)



    }

    private fun <T: Comparable<T>> sort(a: Array<T>) {
        val N = a.size

        for (i in 0 until N) {
            var min = i

            for (j in i + 1 until N) {
                if (a[j] < a[min]) {
                    min = j
                }
            }
            exch(a, i, min)
        }
    }

    private fun <T: Comparable<T> >exch(a: Array<T>, i: Int, j: Int) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }

    // print array to standard output
    private fun <T: Comparable<T>> show(a: Array<T>) {
        for (i in a.indices) {
            StdOut.println(a[i])
        }
    }
}