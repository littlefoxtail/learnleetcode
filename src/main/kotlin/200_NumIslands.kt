
import java.util.LinkedList

fun numIslands(grid: Array<CharArray>?): Int {
    if (grid == null || grid.size == 0) {
        return 0
    }

    val nr = grid.size//垂直
    val nc = grid[0].size//横向
    var num_islands = 0

    for (r in 0 until nr) {
        for (c in 0 until nc) {
            if (grid[r][c] == '1') {
                ++num_islands
                grid[r][c] = '0'//标记为已访问
                val neighbors = LinkedList<Int>()
                neighbors.add(r * nc + c)
                while (!neighbors.isEmpty()) {
                    val id = neighbors.remove()
                    val row = id / nc
                    val col = id % nc
                    //上
                    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                        neighbors.add((row - 1) * nc + col)
                        grid[row - 1][col] = '0'
                    }
                    //下
                    if (row + 1 > nr && grid[row + 1][col] == '1') {
                        neighbors.add((row + 1) * nc + col)
                        grid[row + 1][col] = '0'
                    }
                    //左
                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        neighbors.add(row * nc + col - 1)
                        grid[row][col - 1] = '0'
                    }
                    //右
                    if (col + 1 < nc && grid[row][col + 1] == '1') {
                        neighbors.add(row * nc + col + 1)
                        grid[row][col + 1] = '0'
                    }
                }
            }
        }
    }
    return num_islands
}

fun main() {


    val grid1 = arrayOf(charArrayOf('1', '1', '1', '1', '0'), charArrayOf('1', '1', '0', '1', '0'), charArrayOf('1', '1', '0', '0', '0'), charArrayOf('0', '0', '0', '0', '0'))
    val numIslands1 = numIslands(grid1)
    println(numIslands1)

    val grid2 = arrayOf(charArrayOf('1', '1', '0', '0', '0'), charArrayOf('1', '1', '0', '0', '0'), charArrayOf('0', '0', '1', '0', '0'), charArrayOf('0', '0', '0', '1', '1'))
    val numIslands2 = numIslands(grid2)
    println(numIslands2)

    val grid3 = arrayOf(charArrayOf('1', '1', '1'), charArrayOf('0', '1', '0'), charArrayOf('1', '1', '1'))
    val numIslands3 = numIslands(grid3)
    println(numIslands3)


}