
import java.util.LinkedList

internal class Node(var `val`: Int, var step: Int)

fun numSquares(n: Int): Int {
    val queue = LinkedList<Node>()
    queue.add(Node(n, 0))
    val visited = BooleanArray(n + 1)
    while (!queue.isEmpty()) {
        val num = queue.peek().`val`
        val step = queue.peek().step
        queue.remove()
        var i = 0
        while (true) {
            val a = num - i * i
            if (a < 0) {
                break
            }
            //若a已经计算到0了，就不必在往下执行了
            if (a == 0) {
                return step + 1
            }
            if (!visited[a]) {
                queue.add(Node(a, step + 1))
                visited[a] = true
            }
            i++

        }

    }
    return -1
}

fun main() {
    print(numSquares(12))
}