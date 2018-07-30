package tree

/**
 * 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
2
/ \
1   3
输出: true
示例 2:

输入:¡
5
/ \
1   4
/ \
3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
根节点的值为 5 ，但是其右子节点值为 4 。
 */
object isValidBST {

    @JvmStatic
    fun main(args: Array<String>) {
//        var root = TreeNode(5)
//        root.left = TreeNode(1)
//        root.right = TreeNode(4)
//
//        root.right?.left = TreeNode(3)
//        root.right?.right = TreeNode(6)
//
//        println(isValidBST.isValidBST(root))
//
//        firstNode = true
//        lastVal = Integer.MIN_VALUE
        var root = TreeNode(2)
        root.left = TreeNode(1)
        root.right = TreeNode(3)

        println(isValidBST.isValidBST(root))
    }

    private var lastVal = Integer.MIN_VALUE
    private var firstNode = true


    /**
     * 采用遍历法
     * 时间复杂度O(n)
     */
    private fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        if (!isValidBST(root.left)) {
            return false
        }

        if (!firstNode && lastVal >= root.`val`) {
            return false
        }
        firstNode = false
        lastVal = root.`val`
        if (!isValidBST(root.right)) {
            return false
        }
        return true


    }
}