
import java.util.ArrayList;
import java.util.List;

/**
 * An example of maximum binary heap
 * implement list as heap
 * @author yuantechang
 *
 */
public class Example1 {
	
	private List<Integer> heap = new ArrayList<>(); 

	public Example1() {}

	public static void main(String[] args) {
		// 測試最大二元堆
		Example1 binaryHeap = new Example1();
		
		binaryHeap.add(19);
		binaryHeap.add(36);
		binaryHeap.add(100);
		binaryHeap.add(17);
		binaryHeap.add(7);
		binaryHeap.add(3);
		binaryHeap.add(2);
		binaryHeap.add(25);
		binaryHeap.add(1);
		
		binaryHeap.print();
		
		System.out.println(binaryHeap.popMax());
		binaryHeap.print();
		System.out.println(binaryHeap.popMax());
		binaryHeap.print();
		System.out.println(binaryHeap.popMax());
		binaryHeap.print();
		System.out.println(binaryHeap.popMax());
		System.out.println(binaryHeap.popMax());
		
	}
	
	/**
	 * 加入元素
	 * 時間複雜度:O(logn)
	 * 空間複雜度:O(n)
	 * @param value
	 * @return
	 */
	public boolean add(Integer value) {
		if(heap.add(value)) {
			floatElement(heap.size() -1);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 回傳最大值
	 * 時間複雜度:O(1)
	 * @return 堆中的最大值
	 */
	public Integer peepMax() {
		if(heap.size() == 0) return null;		
		return heap.get(0);
	}
	
	/**
	 * 冒出最大值並移除
	 * 時間複雜度: O(logn)
	 * @return 堆中的最大值
	 */
	public Integer popMax() {
		if(heap.size() == 0) return null;		
		int tailIndex = heap.size() - 1 ;
		swapElement(0, tailIndex);
		int max = heap.remove(tailIndex);
		sinkElement(0);
		return max;
	}
	
	/*
	 * 子節點元素移至父節點
	 */
	private void floatElement(int fromIndex) {
		int toIndex = (fromIndex - 1) / 2; // parent node
		if(fromIndex > 0 && heap.get(toIndex) < heap.get(fromIndex)) { // parent > children
			swapElement(toIndex, fromIndex);
			floatElement(toIndex);
		}
	}
	
	/*
	 * 父節點元素移至子節點；保持左>右
	 */
	private void sinkElement(int fromIndex) {
		int toIndex1 = 2 * fromIndex + 1; // child node 1
		
		if(toIndex1 < heap.size()) {
			int toIndex2 = 2 * fromIndex + 2;
			if(toIndex2 < heap.size() && heap.get(toIndex2) > heap.get(toIndex1)) toIndex1 = toIndex2; // child: node1 > node 2
			
			if(heap.get(toIndex1) > heap.get(fromIndex)) {
				swapElement(toIndex1, fromIndex);
				sinkElement(toIndex1);
			}
		}
	}
	
	/*
	 * 交換指定的節點值
	 */
	private void swapElement(int index1, int index2) {
		heap.set(index1, heap.get(index1) ^ heap.get(index2));
		heap.set(index2, heap.get(index1) ^ heap.get(index2));
		heap.set(index1, heap.get(index1) ^ heap.get(index2));
	}
	
	/**
	 * 印出堆，以陣列表示
	 */
	public void print() {
		for(Integer elem : heap) {
			System.out.print(elem + ",");
		}
		System.out.println();
	}

}
