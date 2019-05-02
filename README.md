
<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

* [概述](#概述)
	* [时间复杂度](#时间复杂度)
	* [数据结构](#数据结构)
		* [Linked List](#linked-list)
		* [链表的应用](#链表的应用)
		* [Stack](#stack)
		* [Queue](#queue)
		* [Tree](#tree)
			* [Binary Tree](#binary-tree)
			* [存储二叉树](#存储二叉树)
				* [顺序存储（数组存储）](#顺序存储数组存储)
			* [二叉链表存储](#二叉链表存储)
			* [Binary Search Tree](#binary-search-tree)
			* [搜索](#搜索)
				* [广度优先搜索](#广度优先搜索)
	* [Trie](#trie)
	* [Fenwick Tree](#fenwick-tree)
	* [Heap](#heap)
	* [Hashing](#hashing)
	* [递归](#递归)

<!-- /code_chunk_output -->

# 概述

算法，在数学和计算机科学之中，为任何良定义的具体步骤的一个序列，常用于计算、数据梳理和自动推理。算法是一个有限长列表的有效方法。算法应包含清晰定义的指令用于计算函数。
算法中的指令描述的是一个计算，当其运行时能从一个初始状态和初始输入开始，经过一系列有效而清晰定义的状态最终产生输出并停止于一个终态。

算法的特征：

* 输入：一个算法必须有零个或以上输入量 
* 输出：一个算法应有一个或者以上输入量，输出量是算法计算的结果
* 明确性：算法的描述必须无歧义，以保证算法的实际执行结果是精确匹配要求或者期望，通常要求实际结果是确定的
* 有限性：依据图灵的定义，一个算法是能够被任何图灵完全系统模拟的一串运算，而图灵机只有有限个状态、有限个输入符号和有限个转移函数（指令）。而一些定义更规定算法必须在有限个步骤内完成任务
* 有效性：又称可行性。能够实现，算法中描述的操作都是可以通过已经实现的基本运算执行有限次来实现。

常用的设计模式：

* 完全遍历和不完全遍历法：最简单的算法就是把解空间的所有元素完全遍历一遍，逐个检测元素是否为我们要的解。这是最直接的算法，实现往往最简单。当解空间特别庞大时，这种算法很可能导致工程上无法承受的计算量。这时候可以利用不完全遍历方法--例如各种搜索法和规划法---来减少计算量
* 分治法：把一个问题分割成互相独立的多个部分分别求解的思路，这种求解思路带来的好处之一便于进行并行计算
* 动态规划法：当问题的整体最优解就是局部最优解组成的时候，经常采用的一种方法
* 贪心算法：场景的近似求解思路。当问题的整体最优解不是由局部最优解组成，且对解的最优性没有要求的时候，可以采用的一种方法


- **[二叉树](binarytree.md)**
- **[排序算法](sort.md)**
- **[LeetCode](leetcode.md)**

## 渐近分析

在数学分析中一种在极限附近的行为的方法。
最简单的例子如下：考虑一个函数f(n)，需要了解当n变得非常大的时候f(n)的性质。
令<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/5a01c613dc3f32ede732d43f7aa1f941efac127a" class="mwe-math-fallback-image-inline" aria-hidden="true" style="vertical-align: -0.838ex; width:15.428ex; height:3.176ex;" alt="f(n) = n^{2}+3n">，在n特别大的时候，第二项3n比起第一项<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/ac9810bbdafe4a6a8061338db0f74e25b7952620" class="mwe-math-fallback-image-inline" aria-hidden="true" style="vertical-align: -0.338ex; width:2.449ex; height:2.676ex;" alt="n^{2}">要小的很多。
于是对于这个函数，有如下断言："<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/c1c49fad1eccc4e9af1e4f23f32efdc3ac4da973" class="mwe-math-fallback-image-inline" aria-hidden="true" style="vertical-align: -0.838ex; width:4.483ex; height:2.843ex;" alt="f(n)">在<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/9702f04f2d0e5b887b99faeeffb0c4cfd8263eee" class="mwe-math-fallback-image-inline" aria-hidden="true" style="vertical-align: -0.338ex; width:7.333ex; height:1.843ex;" alt="n\rightarrow \infty">无穷的情况下与<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/ac9810bbdafe4a6a8061338db0f74e25b7952620" class="mwe-math-fallback-image-inline" aria-hidden="true" style="vertical-align: -0.338ex; width:2.449ex; height:2.676ex;" alt="n^{2}">渐近等价"，记作：<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/acf586a9dfd9d7f43343f3ca49b65a19707baeda" class="mwe-math-fallback-image-inline" aria-hidden="true" style="vertical-align: -0.838ex; width:10.03ex; height:3.176ex;" alt="f(n)\sim n^2">。

## 时间复杂度

在计算机科学中，算法的时间复杂度是一个函数，它定量描述了该算法的运行时间。这是一个代表算法输入值的字符串长度的函数。
时间复杂度常用大O符号表示，不包括这个函数的低阶项和首项系数。使用这种方式时，时间复杂度可称为渐近的，亦即考察输入大小趋近无穷时的情况。
为了计算时间复杂度，通常会估计算法的操作单元数量，每个单元运行的时间都是相同的，因此，总运行时间和算法的操作单元数量最多相差一个常量系数
相同大小的不同输入值仍可能造成算法的运行时间不同，因此通常使用算法的最坏时间复杂度，记为<b><i>T</i>(<i>n</i>)</b>，定义为任何大小的输入n所需的最大运行时间。另一种较少使用的方法是平均情况复杂度，通常有特别指定才会使用。时间复杂度可以用函数<i>T</i>(<i>n</i>)的自然特性加以分类。

> 首项系数：![fx](https://latex.codecogs.com/gif.latex?f(x)%20=%20a_nx^n%20+%20a_{n-1}x^{n-1}%20+...+a_1x%20+%20a_0)的 ![a_n](https://latex.codecogs.com/gif.latex?a_n)称为f(x)的首项系数
> 低阶项：除了最高项。

使用这种方式时，时间复杂度可被称为是渐近的，亦即考察输入值大小趋近无穷时的情况。
为了计算时间复杂度，通常会估计算法的操作单元数量，每个单元运行的时间都是相同的。因此，总运行时间和算法的操作单元数量最多相差一个常量系数。
相同大小的不同输入值仍可能造成算法的运行时间不同，通常使用算法的最坏情况复杂度，T(n)，定义为任何大小的输入n所需的最大运行时间。另一种较少使用方法是平均算法复杂度

## 空间复杂度

算法的空间复杂度是指算法需要消耗的空间资源。其计算和表示方法与时间复杂度类似，一般用复杂度的渐进性来表示。同时间复杂度相比，空间复杂度的分析要简单得多

