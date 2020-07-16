package min_heap;

public class Driver {

	/*Creates heap, fills with elements, in random order to force heap organization.
	 * Prints result
	 * 
	 */
	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.push(73);
		heap.push(54);
		heap.push(99);
		heap.push(22);
		heap.push(22);
		heap.push(22);
		heap.push(22);
		heap.push(22);
		heap.push(46);
		heap.push(72);
		heap.push(52);
		heap.push(2);
		heap.push(0);

		heap.printHeap();
	}

}
