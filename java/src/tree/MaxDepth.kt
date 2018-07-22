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

    val treeNode1_left = TreeNode(9)
    val treeNode1_right = TreeNode(20)
    head.left = treeNode1_left
    head.right = treeNode1_right

    val treeNode2_left = TreeNode(15)
    val treeNode2_right = TreeNode(7)

    treeNode1_right.left = treeNode2_left
    treeNode1_right.right = treeNode2_right

    print(maxDepth(head))

  }

  private fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
      return 0
    }
    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return Math.max(left, right) + 1

  }
}