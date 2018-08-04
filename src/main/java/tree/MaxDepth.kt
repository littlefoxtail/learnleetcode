package tree

/**
 * 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

3
/ \
9  20
/  \
15   7
返回它的最大深度 3 。
 */
object MaxDepth {

  @JvmStatic
  fun main(args: Array<String>) {

    val head = TreeNode(3)

    head.left = TreeNode(9)
    head.right = TreeNode(20)
    head.left?.left = null
    head.left?.right = null


    head.right?.left = TreeNode(15)
    head.right?.right = TreeNode(7)

    print(maxDepth2(head))

  }

  private fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return Math.max(left, right) + 1

  }

  private var depth: Int = 0

  private fun maxDepth2(root: TreeNode?): Int {
    depth = 0
    helper(root, 1)
    return depth
  }

  private fun helper(node: TreeNode?, curtDepth: Int) {
    if (node == null) {
      return
    }

    if (curtDepth > depth) {
      depth = curtDepth
    }

    helper(node.left, curtDepth + 1)
    helper(node.right, curtDepth + 1)

  }
}