fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    // 0 00
    // 1 01 10
    // 2 20 11 02
    // 3 12 21
    // 4 22
    val ylength = matrix.size
    if (ylength == 0) {
        return intArrayOf()
    }
    var flags = 0
    val xlength = matrix[0].size
    val result = IntArray(ylength * xlength)
    for (i in 0..ylength + xlength) {
        if (i % 2 == 0) {
            // 正向， 从大到小
            for (j in ylength downTo 0) {
                if (j in 0 until ylength && i - j >= 0 && i - j < xlength) {
                    result[flags++] = matrix[j][i - j]
                }
            }
        } else {
            //逆序，从小到大
            for (j in 0..ylength) {
                if (j in 0 until ylength && i - j >= 0 && i - j < xlength) {
                    result[flags++] = matrix[j][i - j]
                }
            }
        }
    }
    return result

}

fun main() {

    val findDiagonalOrder = findDiagonalOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
    for (i in findDiagonalOrder) {
        print(i)
    }
}