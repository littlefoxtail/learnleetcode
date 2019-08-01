
import java.util.ArrayList

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val ans = ArrayList<Int>()
    if (matrix.isEmpty()) {
        return ans
    }
    val R = matrix.size
    val C = matrix[0].size
    val seen = Array(R) { BooleanArray(C) }
    val dr = intArrayOf(0, 1, 0, -1)
    val dc = intArrayOf(1, 0, -1, 0)
    var r = 0
    var c = 0
    var di = 0
    for (i in 0 until R * C) {
        ans.add(matrix[r][c])
        seen[r][c] = true
        val cr = r + dr[di]
        val cc = c + dc[di]
        if (cr in 0 until R && 0 <= cc && cc < C && !seen[cr][cc]) {
            r = cr
            c = cc
        } else {
            di = (di + 1) % 4
            r += dr[di]
            c += dc[di]
        }
    }
    return ans

}

fun main() {
    print(spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))))
}