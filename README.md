# BinaryHeap
 A Java implementation of binary heap

## 觀念
二元堆是一種完全二元樹(complete binary tree)可分為最大二元堆、最小二元堆，特色是取出的資料有序，在排序檢索時的時間複雜度僅有O(1)十分迅速。  
二元堆常用於
* 第k名問題(k-th largest problem)
* 帶優先級的佇列(priority queue)

## 實作
二元堆可使用Map或List實作二元樹，空間複雜度為O(n)。  
因為二元堆是完全二元樹，因此使用中序表示儲存樹結構時，有以下特色:
* 若父節點的指標為i則子節點為 2i+1, 2i+2 (0為底表示)
* m階二元堆的資料長度n在 (m - 1)<sup>2</sup> 到 m<sup>2</sup> 之間

二元堆每次增加/移除元素時，都要進行重組以平衡樹節點之間的關係。重組算法的時間複雜度為 O(logn)。   
若父節點>左子節點>右子節點則為最大二元堆；若父節點<左子節點<右子節點則為最小二元堆  
加入元素的操作稱為"上浮"；移除元素的操作稱為"下沉"。

## 參考資料
[算法学习笔记(47): 二叉堆 - Pecco的文章 - 知乎](https://zhuanlan.zhihu.com/p/187618450)  
[Kadai 2019](https://medium.com/@Kadai/資料結構大便當-binary-heap-ec47ca7aebac)