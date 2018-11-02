public class BinaryHeap {	

	//data members
	int[] a;
	int size;

	public BinaryHeap() {

		a = new int[10];

		size = 0;

	}

	public void add(int p) {

		if (size == a.length) 

			grow();

		a[size] = p;

		int index = size;

		int parent = (index - 1) / 2;

		while ((index > 0) && (a[index] < a[parent])) {

			swap(index, parent, a);

			index = parent;

			parent = (index - 1) / 2;

		}

		size++;

	}

	public int remove() {

		int p = a[0];

		a[0] = a[size - 1];

		shiftdown(0);

		size--;

		return p;
		
	}

	public void swap(int pos, int curr, int[] a) {

		int temp = a[pos];

		a[pos] = a[curr];

		a[curr] = temp;

	}

	public void shiftdown(int parent) {

		int child = parent * 2 + 1;

		if (child >= size)

			return;

		if (a[child + 1] < a[child])

			child++;

		if (a[parent] > a[child]) {

			swap(child, parent, a);

			shiftdown(child);

		}
	}

	public void grow() {

		int[] b = new int[a.length * 2];

		for (int i = 0; i < a.length; i++)

			b[i] = a[i];

		a = b;
		
	}
}