package tree

import java.util.LinkedList

/**
 * 广度优先
 */
object LevelOrder {
  @JvmStatic
  fun main(args: Array<String>) {
    val head = TreeNode(3)
    head.left = TreeNode(9)
    head.right = TreeNode(20)

    head.right?.left = TreeNode(15)
    head.right?.right = TreeNode(7)

    levelOrder(head)

  }

  /**
   * 层序遍历二叉树是典型的广度优先搜索BFS的应用
   */
  fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = ArrayList<ArrayList<Int>>()

    if (root == null) {
      return result
    }

    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    while (!queue.isEmpty()) {
      val level: ArrayList<Int> = ArrayList()
      val size = queue.size

      for (i in 0 until size) {
        val head = queue.poll()
        level.add(head.`val`)
        if (head.left != null) {
          queue.offer(head.left)
        }
        if (head.right != null) {
          queue.offer(head.right)
        }
      }
      result.add(level)
    }
    return result
  }
}