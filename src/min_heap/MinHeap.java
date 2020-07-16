package min_heap;

import java.util.Arrays;

public class MinHeap {
	
	private int length;
	private int size;
	private int[] heap;
	
	/* Constructor
	 * 
	 */
	public MinHeap() {
		this.length = 10;
		this.size = 0;
		this.heap = new int[length];
	}
	
	/* Prints the heap array
	 * 
	 */
	public void printHeap() {
		for (int i =0; i < this.heap.length; i++) {
			System.out.println(this.heap[i]);
		}
	}
	/* First checks if array is empty and returns and exception
	 * if so.  Otherwise, returns the first element in the array
	 */
	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
			
		}
		
		return this.heap[0];
	}
	
	/* Removes the smallest element from the heap
	 * 
	 */
	public int pop() {
		if (this.size == 0) {
			throw new IllegalStateException();
		}
		
		int element = this.heap[0];
		this.size--;
		heapifyDown();
		return element;
	}
	
	
	/* Adds element to heap, maintains organization
	 * 
	 */
	public void push(int element) {
		expandCapacity();
		this.heap[this.size] = element;
		this.size++;
		heapifyUp();
	}
	
	
	/* Bubbles smaller elements up to appropriate position in heap
	 * 
	 */
	public void heapifyUp() {
		int currIndex = this.size - 1;
		while (hasParent(currIndex) && parent(currIndex) > this.heap[currIndex]) {
			swap(getParentIndex(currIndex), currIndex);
			currIndex = getParentIndex(currIndex);
		}
	}
	
	/* Bubbles larger elements down to appropriate position in heap
	 * 
	 */
	public void heapifyDown() {
		int currIndex = 0;
		boolean notHeap = true;
		while (hasLeftChild(currIndex) && notHeap) {
			int smallerChildIndex = getLeftChildIndex(currIndex);
			if (hasRightChild(currIndex) && rightChild(currIndex) < leftChild(currIndex)) {
				smallerChildIndex = getRightChildIndex(currIndex);
			}
			
			if (this.heap[currIndex] < this.heap[smallerChildIndex]) {
				notHeap = false;
			} else {
				swap(currIndex, smallerChildIndex);
			}
			currIndex = smallerChildIndex;
		}
	}
	
	/* Swaps two elements in a given array
	 * 
	 */
	private void swap(int indexOne, int indexTwo) {
		int temp = this.heap[indexOne];
		heap[indexOne] = heap[indexTwo];
		heap[indexTwo] = temp;
	}
	
	/* Checks if array is full, doubles capacity if so
	 * 
	 */
	private void expandCapacity() {
		if (this.size == this.length) {
			this.heap = Arrays.copyOf(this.heap, this.length * 2);
			this.length *= 2;
			
		}
	}
	
	/* Returns corresponding index of left child in heap array
	 * 
	 */
	private int getLeftChildIndex(int parentIndex) {
	
		return 2 * parentIndex + 1;
	}
	
	/* Returns corresponding index of right child in heap array
	 * 
	 */
	private int getRightChildIndex(int parentIndex) {
		
		return 2 * parentIndex + 2;
	}
	
	/* Returns corresponding index of parent element in heap array
	 * 
	 */
	private int getParentIndex(int childIndex) {
		
		return (childIndex - 1) / 2;
	}
	
	/* Returns True if element at given index has a left child
	 * 
	 */
	private boolean hasLeftChild(int index) {
		
		return getLeftChildIndex(index) < this.size;
	}
	
	/* Returns True if element at given index has a right child
	 * 
	 */
	private boolean hasRightChild(int index) {
		
		return getRightChildIndex(index) < this.size;
	}
	
	/* Returns True if element at given index has a parent
	 * 
	 */
	private boolean hasParent(int index) {
		
		return getParentIndex(index) >= 0;
	}
	
	/* Returns value of the left child of the element at the given index
	 * 
	 */	
	private int leftChild(int index) {
		
		return this.heap[getLeftChildIndex(index)];
	}

	/* Returns value of the right child of the element at the given index
	 * 
	 */	
	private int rightChild(int index) {
		
		return this.heap[getRightChildIndex(index)];
	}
	
	/* Returns value of the parent of the element at the given index
	 * 
	 */		
	private int parent(int index) {
		
		return this.heap[getParentIndex(index)];
	}
}
