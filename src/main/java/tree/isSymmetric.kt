package tree

import java.util.*

/**
 * 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

™1
/ \
2   2
/ \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

1
/ \
2   2
\   \
3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
object isSymmetric {

  @JvmStatic
  fun main(args: Array<String>) {
    val root = TreeNode(1)

    root.left = TreeNode(2)
    root.right = TreeNode(2)

    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)

    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)


    println(isSymmetric2(root))

  }

  fun isSymmetric2(root: TreeNode?): Boolean {
    if (root == null)
      return true
    return isSymmetric(root.left, root.right)
  }


  fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    if (left.`val` == right.`val`)
      return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)
    return false
  }

      /**
       * 使用BFS对整个二叉树进行层级遍历。在每层中使用Stack判断是否对称。
       *
       * 用queue存储每一层的二叉树
       */

  fun isSymmetric(root: TreeNode?): Boolean {

    val queue: Queue<TreeNode?> = LinkedList()
    val stack: Stack<TreeNode?> = Stack()
    queue.offer(root)
    var current: TreeNode?
    var size: Int
    var isSymmetric: Boolean

    while (!queue.isEmpty()) {
      size = queue.size
      val indices = queue.indices
      for (i: Int in indices) {

        current = queue.poll()
        if (current != null) {
          queue.offer(current.left)
          queue.offer(current.right)
        }
        if (size == 1) {
          break
        }
        if (size % 2 != 0) {
          return false
        }

        if (i < size / 2) {
          stack.push(current)
        } else {
          isSymmetric = if (current == null) {
            current == stack.pop()
          } else {
            current.`val` == stack.pop()?.`val`
          }
          if (!isSymmetric) {
            return false
          }
        }

      }
    }


    return true
  }
}